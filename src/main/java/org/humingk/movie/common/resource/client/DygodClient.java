package org.humingk.movie.common.resource.client;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.type.ClientType;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.List;

/**
 * 获取 dygod 资源信息
 *
 * @author lzx
 * @author humingk
 */
public class DygodClient extends AbstractMovieResourceAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 基本 URL
     */
    private static final String BASE_URL = "https://www.dygod.net";

    /**
     * 通过关键字获取电影搜索结果
     *
     * @param keyword 搜索关键字
     * @param max     每个网站电影搜索结果最大数
     */
    @Override
    public List<Search> getMovieSearch(String keyword, int max) {
        List<Search> result = null;
        String url = BASE_URL + "/e/search/index.php";
        try {
            String data = "show=title&tempid=1&keyboard=" + URLEncoder.encode(keyword, "gb2312") + "&Submit=%C1%A2%BC%B4%CB%D1%CB%F7";
            Document doc = httpUrlConnRequest(url, data, "POST");
            Elements movieList = doc.select("table.tbspan a");
            if (movieList.size() != 0) {
                // 解析搜索页面
                result = parseSearch(keyword, ClientType.CLIENT_DYGOD, max, BASE_URL, movieList);
                logger.debug("(电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("(电影天堂)获取电影搜索列表失败...keyword: " + keyword + " searchUrl: " + url, e);
        }
        return result;
    }


    /**
     * 通过电影url获取电影资源
     *
     * @param search 搜索页面信息
     * @return
     */
    @Override
    public List<Resource> getMovieResource(Search search) {
        List<Resource> result = null;
        try {
            Document doc = jsoupRequest(search.getMovieUrl(), Connection.Method.GET);
            Elements movieList = doc.select("div#Zoom table a");
            if (movieList.size() != 0) {
                // 解析迅雷链接和磁力链接
                result = parseMagnetAndThunder(search.getKeyword(), ClientType.CLIENT_DYGOD, movieList);
                logger.debug("(电影天堂)获取电影资源成功...keyword: " + search.getKeyword()
                        + " size: " + movieList.size()
                        + " movieName: " + search.getMovieName() +
                        " movieUrl: " + search.getMovieUrl());
            }
        } catch (Exception e) {
            logger.error("(电影天堂)获取电影资源失败...keyword: " + search.getKeyword()
                    + " movieName: " + search.getMovieName() +
                    " movieUrl: " + search.getMovieUrl(), e);
        }
        return result;
    }
}
