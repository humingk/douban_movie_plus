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

import java.util.*;

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
    @Override
    public void setSearchList(
            String keyword, int searchFlag, int resourceFlag, List<Search> searchList) {
        try {
            // keyword
            keywordMapper.insertAndUpdate(keyword, searchFlag, resourceFlag);
            // search
            for (Search search : searchList) {
                searchMapper.insert(search);
            }
        } catch (Exception e) {
            logger.error("insert keyword and search failed,keyword: " + keyword, e);
        }
    }

    /**
     * 向数据库存放电影资源
     *
     * @param resourceList
     */
    @Override
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
     * 通过关键字从数据库获取电影搜索列表
     *
     * @param keyword
     * @param searchMax
     * @return
     */
    @Override
    public List<Search> getSearchList(String keyword, int searchMax) {
        List<Search> result = new LinkedList<>();
        try {
            List<Search> searchList = searchMapper.selectByKeyword(keyword);
            Map<Integer, List<Search>> clientMap = new LinkedHashMap<>();
            if (searchList != null) {
                //按照 client 分类
                for (Search search : searchList) {
                    clientMap.computeIfAbsent(search.getClientType(), k -> new LinkedList<>());
                    clientMap.get(search.getClientType()).add(search);
                }
                // client计数
                int count = 0;
                // 每个client取最大数
                for (Integer key : clientMap.keySet()) {
                    for (int i = 0; i < clientMap.get(key).size() && i < searchMax; i++) {
                        result.add(clientMap.get(key).get(i));
                    }
                    // 此client未达到最大数
                    if (clientMap.get(key).size() < searchMax) {
                        count++;
                    }
                }
                // 如果每一个client都没有达到最大值,则刷新Search列表
                if (count == clientMap.size()) {
                    result = new MovieResourceThread().getResourceSearch(keyword, searchMax, 5);
                    // 数据库加入关键字，搜索列表，searchFlag标记为已搜索
                    setSearchList(keyword, 1, 0, result);
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 通过关键字获取电影资源---电影搜索结果
     *
     * @param keyword        搜索关键字
     * @param dateType       电影上映时间类型
     *                       0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                       1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                       2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @param searchMax 每个网站电影搜索最大数
     * @param threadMax      线程最大数
     * @return
     */
    @Override
    public List<Search> getResourceSearch(
            String keyword, int dateType, int searchMax, int threadMax) {
        List<Search> result = null;
        try {
            // 始终请求搜索电影列表
            if (dateType == 0) {
                // 实时爬虫获取电影搜索列表
                result = new MovieResourceThread().getResourceSearch(keyword, searchMax, threadMax);
                // 数据库加入关键字，搜索列表，searchFlag标记为未搜索
                setSearchList(keyword, 0, 0, result);
            }
            // 看情况请求搜索电影列表
            else if (dateType == 1 || dateType == 2) {
                Keyword keywordEntity = keywordMapper.selectByPrimaryKey(keyword);
                // 数据库已有关键字
                if (keywordEntity != null) {
                    // 虽有关键字，但需要刷新
                    if (keywordEntity.getSearchFlag() == 0) {
                        // 实时爬虫获取电影搜索列表
                        result = new MovieResourceThread().getResourceSearch(keyword, searchMax, threadMax);
                        // 数据库加入关键字，搜索列表，searchFlag标记为已搜索
                        setSearchList(keyword, 1, 0, result);
                    }
                    // 有关键字且不需要刷新
                    else if (keywordEntity.getSearchFlag() == 1) {
                        // 从数据库获取搜索结果
                        result = getSearchList(keyword, searchMax);
                    }
                }
                // 数据库没有关键字
                else {
                    // 实时爬虫获取搜索结果
                    result = new MovieResourceThread().getResourceSearch(keyword, searchMax, threadMax);
                    // 数据库加入关键字，搜索列表，searchFlag标记为已搜索
                    setSearchList(keyword, 1, 0, result);
                }
            }
        } catch (Exception e) {
            logger.error("通过关键字获取资源电影搜索结果失败", e);
        }
        return result;
    }

    /**
     * 通过关键字获取电影资源---电影资源
     *
     * @param keyword        搜索关键字
     * @param dateType       电影上映时间类型
     *                       0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                       1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                       2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @param movieSearchMax 每个网站电影搜索最大数(仅用于没有获取过电影搜索结果情况)
     * @param threadMax      线程最大数
     * @return
     */
    @Override
    public List<Resource> getResourceAll(
            String keyword, int dateType, int movieSearchMax, int threadMax) {
        List<Resource> result = null;
        try {
            Keyword keywordEntity = keywordMapper.selectByPrimaryKey(keyword);
            // 数据库没有关键字，先获取电影列表再获取电影资源
            if (keywordEntity == null) {
                // 获取电影搜索列表
                getResourceSearch(keyword, dateType, movieSearchMax, threadMax);
                // 获取电影搜索资源
                result = getResourceAll(keyword, dateType, movieSearchMax, threadMax);
            }
            // 数据库有关键字
            else {
                // 始终实时爬虫请求电影资源
                if (dateType == 0 || dateType == 1) {
                    // 从数据库获取搜索列表
                    List<Search> searchList = getSearchList(keyword, movieSearchMax);
                    // 实时爬虫获取电影资源
                    result = new MovieResourceThread().getResourceAll(threadMax, searchList);
                    // 存放电影资源
                    setResourceList(result);
                    // 更新resourceFlag为未搜索
                    keywordMapper.updateResourceFlag(keyword, 0);
                }
                // 看情况请求电影资源
                else if (dateType == 2) {
                    // 数据库已有电影资源
                    if (keywordEntity.getResourceFlag() == 1) {
                        // 从数据库获取电影资源
                        result = resourceMapper.selectByKeyword(keyword);
                    }
                    // 数据库虽有电影资源但需要更新
                    else if (keywordEntity.getResourceFlag() == 0) {
                        // 从数据库获取电影列表
                        List<Search> searchList = getSearchList(keyword, movieSearchMax);
                        // 实时爬虫获取电影资源
                        result = new MovieResourceThread().getResourceAll(threadMax, searchList);
                        // 更新数据库电影资源
                        setResourceList(result);
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
