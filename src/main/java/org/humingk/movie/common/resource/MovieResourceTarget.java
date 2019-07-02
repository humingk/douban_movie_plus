package org.humingk.movie.common.resource;

import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
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
     * 通过关键字获取电影搜索结果
     *
     * @param keyword 搜索关键字
     * @param max     每个网站电影搜索结果最大数
     */
    List<Search> getMovieSearch(String keyword, int max);

    /**
     * 通过电影url获取电影资源
     *
     * @param search 搜索页面信息
     * @return
     */
    List<Resource> getMovieResource(Search search);

    /**
     * 解析搜索页面
     *
     * @param keyword
     * @param clientType
     * @param max
     * @param base_url
     * @param elements
     * @return
     */
    List<Search> parseSearch(String keyword, int clientType, int max, String base_url, Elements elements);

    /**
     * 解析磁力资源和迅雷资源
     *
     * @param keywrod
     * @param clientType
     * @param elements
     * @return
     */
    List<Resource> parseMagnetAndThunder(String keywrod, int clientType, Elements elements) throws Exception;

    /**
     * 1. Jsoup方式请求
     *
     * @param url    页面链接
     * @param method 请求类型 默认get
     */
    Document jsoupRequest(String url, Connection.Method method) throws Exception;

    /**
     * 2. HttpURLConnection请求方式
     *
     * @param url    页面链接
     * @param data   提交的数据
     * @param method 请求类型 默认get
     */
    Document httpUrlConnRequest(String url, String data, String method) throws Exception;
}
