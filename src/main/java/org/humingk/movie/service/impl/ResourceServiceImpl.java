package org.humingk.movie.service.impl;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.MovieResourceThread;
import org.humingk.movie.common.resource.pojo.MovieAllResource;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.entity.Keyword;
import org.humingk.movie.entity.KeywordMoviefrom;
import org.humingk.movie.entity.Moviefrom;
import org.humingk.movie.mapper.*;
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
    private MoviefromMapper moviefromMapper;
    @Autowired
    private KeywordMoviefromMapper keywordMoviefromMapper;
    @Autowired
    private ResourcelistMapper resourcelistMapper;
    @Autowired
    private ResourcelistMoviefromMapper resourcelistMoviefromMapper;
    @Autowired
    private ResourcetypeMapper resourcetypeMapper;
    @Autowired
    private ResourcelistResourcetypeMapper resourcelistResourcetypeMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceResourcetypeMapper resourceResourcetypeMapper;
    @Autowired
    private ResourceResourcelistMapper resourceResourcelistMapper;


    /**
     * 通过关键字向数据库存放电影表列表
     *
     * @param keyword
     * @param moviemapFlag     列表搜索标记 默认0
     *                         0 未搜索
     *                         1 已搜索
     * @param resourcelistFlag 资源搜索标记 默认0
     *                         0 未搜索
     *                         1 已搜索
     * @param movieMapList
     * @return
     */
    public boolean setResourceMapList(
            String keyword, int moviemapFlag, int resourcelistFlag,
            List<MovieMap<? extends AbstractMovieResourceAdapter>> movieMapList) {
        boolean result = false;
        try {
            // keyword
            Keyword keywordEntity = new Keyword();
            keywordEntity.setKeywordContent(keyword);
            keywordEntity.setMoviemapFlag(moviemapFlag);
            keywordEntity.setResourcelistFlag(resourcelistFlag);
            keywordMapper.insert(keywordEntity);
            // 电影表列表
            for (MovieMap<? extends AbstractMovieResourceAdapter> movieMap : movieMapList) {
                for (org.humingk.movie.common.resource.pojo.Movie movie : movieMap.getMovies()) {
                    // 电影资源页面
                    Moviefrom moviefrom = new Moviefrom();
                    moviefrom.setMoviefromUrl(movie.getMovieUrl());
                    moviefrom.setMoviefromName(movie.getMovieName());
                    moviefromMapper.insert(moviefrom);
                    // 关联关键字
                    KeywordMoviefrom keywordMoviefrom = new KeywordMoviefrom();
                    keywordMoviefrom.setKeywordContent(keyword);
                    keywordMoviefrom.setMoviefromUrl(movie.getMovieUrl());
                }
            }
            logger.debug("insert movieMap success,keyword: " + keyword);
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 通过关键字从数据库获取电影表列表
     *
     * @param keyword
     * @return
     */
    public List<MovieMap<? extends AbstractMovieResourceAdapter>> getResourceMapList(String keyword) {
        List<MovieMap<? extends AbstractMovieResourceAdapter>> result = null;
        try {
            Keyword keywordEntity = keywordMapper.selectByPrimaryKey(keyword);
            if (keywordEntity != null && keywordEntity.getMoviemapFlag() == 1) {

            }

        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }


    /**
     * 通过关键字获取电影资源:电影表列表
     *
     * @param keyword     搜索关键字
     * @param dateType    电影上映时间类型
     *                    0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                    1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                    2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @param movieMapMax 电影表最大数
     * @param threadMax   线程最大数
     * @return
     */
    @Override
    public List<MovieMap<? extends AbstractMovieResourceAdapter>> getResourceMapList(
            String keyword, int dateType, int movieMapMax, int threadMax) {
        List<MovieMap<? extends AbstractMovieResourceAdapter>> result = null;
        try {
            if (dateType == 0) {
                result = new MovieResourceThread().getMovieMapListByKeyword(keyword, movieMapMax, threadMax);
            } else if (dateType == 1 || dateType == 2) {
                Keyword keywordEntity = keywordMapper.selectByPrimaryKey(keyword);
                if (keywordEntity != null) {
                    // 从数据库获取moviemap
                    if (keywordEntity.getMoviemapFlag() == 1) {
                        result = getResourceMapList(keyword);
                    }
                    // 实时爬虫
                    else if (keywordEntity.getMoviemapFlag() == 0) {

                    }
                }
            }

        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 通过关键字获取电影资源:电影表列表/电影资源
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
    public MovieAllResource getMovieAllResource(
            String keyword, int dateType, int threadMax) {
        return null;
    }
}
