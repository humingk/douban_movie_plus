package org.humingk.movie.service;

import org.humingk.movie.common.MovieAll;
import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.pojo.MovieAllResource;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.entity.Movie;

import java.util.List;

/**
 * @author humingk
 */
public interface MovieService {

    /**
     * 根据电影Id找出电影的详细资料
     *
     * @param movieId
     * @return
     */
    MovieAll getMovieAllByMovieId(int movieId);

    /**
     * 根据电影名称找出所有电影所有的详细资料
     *
     * @param s
     * @param start
     * @param count
     * @return
     */
    List<MovieAll> getMovieAllsOfMovieByAlias(String s, int start, int count);

    /**
     * 根据电影名称开头的字符串找出所有电影的基本资料
     *
     * @param s
     * @return
     */
    List<Movie> getMoviesByNameStart(String s);


    /**
     * 更新电影评分
     *
     * @param movieId
     * @param rate
     */
    boolean updateRateByMovieId(int movieId, float rate);

    /**
     * 更新imdbId
     *
     * @param movieId
     * @param imdbId
     * @return
     */
    boolean updateImdbIdByMovieId(int movieId, String imdbId);


    /**
     * 向数据库添加movieAll
     *
     * @param movieAll
     * @return
     */
    Boolean addMovieAll(MovieAll movieAll);


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
    List<MovieMap<? extends AbstractMovieResourceAdapter>> getResourceMapList(
            String keyword, int dateType, int movieMapMax, int threadMax);

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
    MovieAllResource getMovieAllResource(
            String keyword, int dateType, int threadMax);
}

