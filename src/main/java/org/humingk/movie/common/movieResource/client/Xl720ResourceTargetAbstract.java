package org.humingk.movie.common.movieResource.client;

import org.humingk.movie.common.movieResource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.movieResource.resource.Resource;
import org.humingk.movie.common.movieResource.resource.Xl720Resource;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取 xl720 资源信息
 *
 * @author lzx
 */
public class Xl720ResourceTargetAbstract extends AbstractMovieResourceAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 基本 url
     */
    private static final String BASE_URL = "https://www.xl720.com";

    /**
     * 获取所有资源信息
     *
     * @param keyword
     * @param max     电影最大条数
     * @return
     */
    @Override
    public List<Xl720Resource> getResource(String keyword, int max) {
        List<Xl720Resource> xl720Pojos = new ArrayList<>();
        // 获取电影搜索列表
        Map<String, String> movies = getMovieList(keyword, max);
        if (movies != null && movies.size() != 0) {
            for (String key : movies.keySet()) {
                // 获取电影下载链接
                Xl720Resource xl720Pojo = getMovie(key, movies.get(key));
                if (xl720Pojo != null) {
                    xl720Pojos.add(xl720Pojo);
                }
            }
            return xl720Pojos;
        }
        return null;
    }

    /**
     * 获取电影搜索
     *
     * @param keyword
     * @param max     电影最大数
     * @return
     */
    @Override
    public Map<String, String> getMovieList(String keyword, int max) {
        Map<String, String> movies = new LinkedHashMap();
        String url = BASE_URL + "/?s=" + keyword;
        // 获取电影搜索网页
        Document doc = jsoupRequest(url);
        // 解析搜索页面，获取每部电影的链接
        try {
            Elements elements = doc.getElementsByClass("entry-title  postli-1");
            Elements movieList = elements.select("a");
            if (movieList.size() != 0) {
                logger.debug("(迅雷电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).attr("title");
                    String movieUrl = movieList.get(i).attr("href");
                    movies.put(movieName, movieUrl);
                    logger.debug("(迅雷电影天堂)获取电影 " + movieName + " ...keyword: " + keyword);
                }
                return movies;
            }
            else{
                logger.debug("(迅雷电影天堂)获取电影搜索列表失败...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        return null;
    }

    /**
     * 获取下载链接
     *
     * @param movieName
     * @param movieUrl
     * @return
     */
    @Override
    public Xl720Resource getMovie(String movieName, String movieUrl) {
        Xl720Resource xl720Pojo =  new Xl720Resource();
        xl720Pojo.setMovieName(movieName);
        xl720Pojo.setMovieUrl(movieUrl);
        Document doc = jsoupRequest(movieUrl);
        // 解析网页，获取下载链接
        try {
            List<Resource> thunder = new ArrayList<>();
            List<Resource> magnet = new ArrayList<>();
            Elements movieList1 = doc.select("div.down_btn a");
            Elements movieList2 = doc.select("div.ztxt a");
            if (movieList1.size() != 0 || movieList2.size() != 0) {
                logger.debug("(迅雷电影天堂)获取电影资源成功,共 " + (movieList1.size() + movieList2.size()) + " 条...movieName: " + movieName);
                // 解析迅雷链接和磁力链接
                parseResource(movieList1, thunder, magnet);
                parseResource(movieList2, thunder, magnet);
                xl720Pojo.setThunder(thunder);
                xl720Pojo.setMagnet(magnet);
                return xl720Pojo;
            } else {
                logger.debug("(迅雷电影天堂)获取电影资源失败...movieName: " + movieName);
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        return null;
    }

    public static void main(String[] args) {
        Xl720ResourceTargetAbstract x = new Xl720ResourceTargetAbstract();
        List<Xl720Resource> pojos = x.getResource("蜘蛛侠", 3);
        for(Xl720Resource i : pojos){
            System.out.println(i.getMovieName());
            for(Resource j : i.getMagnet()){
                System.out.println(j.getResourceName()+":"+j.getResourceUrl());
            }
        }
    }
}
