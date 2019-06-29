package org.humingk.movie.common.movieResource;

import org.humingk.movie.common.movieResource.resource.Resource;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

/**
 * 获取电影资源接口
 *
 * @author humingk
 */
public interface MovieResourceTarget {
    /**
     * 通过搜索关键字获取资源列表
     *
     * @param keyword 搜索关键字
     * @param max     电影最大条数
     * @return
     */
    <T> List<T> getResource(String keyword, int max);

    /**
     * 通过指定电影url获取资源
     *
     * @param movieName
     * @param movieUrl
     * @return
     */
    <T> T getMovie(String movieName, String movieUrl);

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
     * 获取电影搜索列表
     *
     * @param keyword 搜索关键字
     * @param max     搜索结果保留最大数
     */
    Map<String, String> getMovieList(String keyword, int max);

    /**
     * 解析 MovieAllResource 为迅雷链接与磁力链接
     *
     * @param elements
     * @param thunders
     * @param magnets
     */
    void parseResource(Elements elements, List<Resource> thunders, List<Resource> magnets);

}
