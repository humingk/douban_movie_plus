package org.humingk.movie.common.resource.client;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.pojo.LoldyttResource;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.Resource;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取Loldytt资源
 *
 * @author lzx
 * @author humingk
 */
public class LoldyttClient extends AbstractMovieResourceAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * client类型
     */
    public static final String CLIENT_TYPE = "loldytt";
    /**
     * 基本 url
     */
    private static final String BASE_URL = "https://www.loldytt.tv";

    /**
     * 获取client类型
     *
     * @return
     */
    @Override
    public String getClientType() {
        return CLIENT_TYPE;
    }

    /**
     * 获取电影搜索列表
     *
     * @param keyword 搜索关键字
     * @param max     搜索结果保留最大数
     */
    @Override
    public MovieMap getMovieMap(String keyword, int max) {
        MovieMap result = null;
        List<Movie> movies = null;
        String url = BASE_URL + "/search/index.asp";
        try {
            // 请求参数
            String data = "keyword=" + URLEncoder.encode(keyword, "gb2312");
            // 获取电影搜索网页
            Document doc = httpUrlConnRequest(url, data, "POST");
            // 解析搜索页面，获取每部电影的链接
            Elements elements = doc.select("div.solb");
            Elements movieList = elements.select("ol a");
            if (movieList.size() != 0) {
                result = new MovieMap(getClientType());
                movies = new ArrayList<>();
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).text();
                    String movieUrl = movieList.get(i).attr("href");
                    movies.add(new Movie(movieName, movieUrl));
                    logger.debug("(LOL电影天堂)获取电影 " + movieName + " ...keyword: " + keyword);
                }
                result.setMovies(movies);
                logger.debug("(LOL电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
            } else {
                logger.debug("(LOL电影天堂)获取电影搜索列表失败...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 通过指定电影url获取资源
     *
     * @param moviePojo
     * @return
     */
    @Override
    public <T> T getMovie(Movie moviePojo) {
        String movieName = moviePojo.getMovieName();
        String movieUrl = moviePojo.getMovieUrl();
        LoldyttResource result = null;
        // 解析网页，获取下载链接
        try {
            Document doc = jsoupRequest(movieUrl, Connection.Method.GET);
            Element movieAll = doc.getElementById("liebiao");
            Elements movieList = movieAll.select("div.con4 li a");
            if (movieList.size() != 0) {
                result = new LoldyttResource();
                result.setMovie(moviePojo);
                // 资源分类
                List<Resource> thunder = new ArrayList<>();
                List<Resource> magnet = new ArrayList<>();
                // 解析迅雷链接和磁力链接
                parseResource(movieList, thunder, magnet);
                result.setThunder(thunder);
                result.setMagnet(magnet);
                logger.debug("(LOL电影天堂)获取电影资源成功,共 " + movieList.size() + " 条...movieName: " + movieName);
            } else {
                logger.debug("(LOL电影天堂)获取电影资源失败...movieName: " + movieName);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return (T) result;
    }
}
