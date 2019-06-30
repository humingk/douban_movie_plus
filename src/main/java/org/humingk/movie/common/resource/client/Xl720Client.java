package org.humingk.movie.common.resource.client;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.Resource;
import org.humingk.movie.common.resource.pojo.site.Xl720Resource;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取 xl720 资源信息
 *
 * @author lzx
 */
public class Xl720Client extends AbstractMovieResourceAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * client类型
     */
    public static final String CLIENT_TYPE = "xl720";
    /**
     * 基本 url
     */
    private static final String BASE_URL = "https://www.xl720.com";

    /**
     * 获取电影搜索列表
     *
     * @param keyword 搜索关键字
     * @param max     搜索结果保留最大数
     */
    @Override
    public MovieMap<Xl720Client> getMovieMap(String keyword, int max) {
        MovieMap<Xl720Client> result = null;
        List<Movie> movies = null;
        String url = BASE_URL + "/?s=" + keyword;
        try {
            // 获取电影搜索网页
            Document doc = jsoupRequest(url, Connection.Method.GET);
            // 解析搜索页面，获取每部电影的链接
            Elements elements = doc.getElementsByClass("entry-title  postli-1");
            Elements movieList = elements.select("a");
            if (movieList.size() != 0) {
                result = new MovieMap<>(keyword, Xl720Client.class);
                movies = new ArrayList<>();
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).attr("title");
                    String movieUrl = movieList.get(i).attr("href");
                    movies.add(new Movie(movieName, movieUrl));
                    logger.debug("(迅雷电影天堂)获取电影 " + movieName + " ...keyword: " + keyword);
                }
                result.setMovies(movies);
                logger.debug("(迅雷电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
            } else {
                logger.debug("(迅雷电影天堂)获取电影搜索列表失败...keyword: " + keyword);
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
    public Xl720Resource getMovie(Movie moviePojo) {
        String movieName = moviePojo.getMovieName();
        String movieUrl = moviePojo.getMovieUrl();
        Xl720Resource result = null;
        try {
            Document doc = jsoupRequest(movieUrl, Connection.Method.GET);
            List<Resource> thunder = new ArrayList<>();
            List<Resource> magnet = new ArrayList<>();
            Elements movieList1 = doc.select("div.down_btn a");
            Elements movieList2 = doc.select("div.ztxt a");
            if (movieList1.size() != 0 || movieList2.size() != 0) {
                result = new Xl720Resource();
                result.setMovie(moviePojo);
                // 解析迅雷链接和磁力链接
                parseResource(movieList1, thunder, magnet);
                parseResource(movieList2, thunder, magnet);
                result.setThunder(thunder);
                result.setMagnet(magnet);
                logger.debug("(迅雷电影天堂)获取电影资源成功,共 " + (movieList1.size() + movieList2.size()) + " 条...movieName: " + movieName);
            } else {
                logger.debug("(迅雷电影天堂)获取电影资源失败...movieName: " + movieName);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }
}
