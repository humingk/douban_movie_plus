package org.humingk.movie.common.resource;

import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.Resource;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * 获取电影资源接口
 *
 * @author humingk
 */
public interface MovieResourceTarget {
    /**
     * 获取client类型
     *
     * @return
     */
    String getClientType();

    /**
     * 获取电影搜索表
     *
     * @param keyword 搜索关键字
     * @param max     搜索结果保留最大数
     */
    MovieMap getMovieMap(String keyword, int max);

    /**
     * 通过指定电影url获取资源
     *
     * @param moviePojo
     * @return
     */
    <T> T getMovie(Movie moviePojo);

    /**
     * 1. Jsoup方式请求
     *
     * @param url    页面链接
     * @param method 请求类型 默认get
     */
    Document jsoupRequest(String url, Connection.Method method);

    /**
     * 2. HttpURLConnection请求方式
     *
     * @param url    页面链接
     * @param data   提交的数据
     * @param method 请求类型 默认get
     */
    Document httpUrlConnRequest(String url, String data, String method);

    /**
     * 解析 MovieAllResource 为迅雷链接与磁力链接
     *
     * @param elements
     * @param thunders
     * @param magnets
     */
    void parseResource(Elements elements, List<Resource> thunders, List<Resource> magnets);

}
