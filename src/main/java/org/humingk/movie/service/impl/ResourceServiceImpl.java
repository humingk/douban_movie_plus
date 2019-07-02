package org.humingk.movie.service.impl;

import org.humingk.movie.common.resource.MovieResourceThread;
import org.humingk.movie.entity.Keyword;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
import org.humingk.movie.mapper.KeywordMapper;
import org.humingk.movie.mapper.ResourceMapper;
import org.humingk.movie.mapper.SearchMapper;
import org.humingk.movie.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资源service
 *
 * @author humingk
 */
@Transactional
@Service
public class ResourceServiceImpl implements ResourceService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KeywordMapper keywordMapper;
    @Autowired
    private SearchMapper searchMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 向数据库存放电影搜索结果
     *
     * @param keyword
     * @param searchFlag   电影搜索标记 默认0
     *                     0 未搜索
     *                     1 已搜索
     * @param resourceFlag 资源搜索标记 默认0
     *                     0 未搜索
     *                     1 已搜索
     * @param searchList
     * @return
     */
    public void setSearchList(
            String keyword, int searchFlag, int resourceFlag, List<Search> searchList) {
        try {
            // keyword
            keywordMapper.replace(new Keyword(keyword, searchFlag, resourceFlag));
            // search
            for (Search search : searchList) {
                searchMapper.insert(search);
            }
        } catch (Exception e) {
            logger.error("insert keyword and search failed,keyword: " + keyword, e);
        }
    }

    /**
     * 通过关键字获取电影资源---电影搜索结果
     *
     * @param keyword        搜索关键字
     * @param dateType       电影上映时间类型
     *                       0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                       1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                       2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @param movieSearchMax 电影搜索最大数
     * @param threadMax      线程最大数
     * @return
     */
    @Override
    public List<Search> getResourceSearch(
            String keyword, int dateType, int movieSearchMax, int threadMax) {
        List<Search> result = null;
        try {
            if (dateType == 0) {
                result = new MovieResourceThread().getResourceSearch(keyword, movieSearchMax, threadMax);
                setSearchList(keyword, 0, 0, result);
            } else if (dateType == 1 || dateType == 2) {
                Keyword keywordEntity = keywordMapper.selectByPrimaryKey(keyword);
                if (keywordEntity != null) {
                    // 从数据库获取搜索结果
                    if (keywordEntity.getSearchFlag() == 1) {
                        result = searchMapper.selectByKeyword(keyword);
                    }
                    // 实时爬虫
                    else if (keywordEntity.getSearchFlag() == 0) {
                        result = new MovieResourceThread().getResourceSearch(keyword, movieSearchMax, threadMax);
                        setSearchList(keyword, 1, 0, result);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("通过关键字获取资源电影搜索结果失败", e);
        }
        return result;
    }

    /**
     * 向数据库存放电影资源
     *
     * @param resourceList
     */
    public void setResourceList(List<Resource> resourceList) {
        try {
            for (Resource resource : resourceList) {
                resourceMapper.insert(resource);
            }
        } catch (Exception e) {
            logger.error("insert resource failed,keyword: " + resourceList.get(0).getKeyword(), e);
        }
    }

    /**
     * 通过关键字获取电影资源---电影资源
     *
     * @param keyword   搜索关键字
     * @param dateType  电影上映时间类型
     *                  0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                  1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                  2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @param threadMax 线程最大数
     * @return
     */
    @Override
    public List<Resource> getResourceAll(
            String keyword, int dateType, int threadMax) {
        List<Resource> result = null;
        try {
            Keyword keywordEntity = keywordMapper.selectByPrimaryKey(keyword);
            if (keywordEntity != null) {
                if (dateType == 0 || dateType == 1) {
                    List<Search> searchList = searchMapper.selectByKeyword(keyword);
                    result = new MovieResourceThread().getResourceAll(threadMax, searchList);
                    // 更新resourceFlag为未搜索
                    keywordMapper.updateResourceFlag(keyword, 0);
                    setResourceList(result);
                } else if (dateType == 2) {
                    // 从数据库获取电影资源
                    if (keywordEntity.getResourceFlag() == 1) {
                        result = resourceMapper.selectByKeyword(keyword);
                    }
                    // 实时爬虫(会出现这种情况??)
                    else if (keywordEntity.getResourceFlag() == 0) {
                        List<Search> searchList = searchMapper.selectByKeyword(keyword);
                        result = new MovieResourceThread().getResourceAll(threadMax, searchList);
                        // 更新resourceFlag为已搜索
                        keywordMapper.updateResourceFlag(keyword, 1);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("通过关键字获取电影资源结果失败", e);
        }
        return result;
    }
}
