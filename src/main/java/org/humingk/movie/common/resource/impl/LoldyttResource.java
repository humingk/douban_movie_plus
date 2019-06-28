package org.humingk.movie.common.resource.impl;

import org.humingk.movie.common.resource.movieResource;
import org.humingk.movie.common.resource.pojo.LoldyttPojo;
import org.humingk.movie.common.resource.pojo.Resource;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取Loldytt 资源信息
 *
 * @author lzx
 */
public class LoldyttResource extends movieResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 基本 url
     */
    private static final String BASE_URL = "https://www.loldytt.tv";

    /**
     * 获取所有资源信息
     *
     * @param keyword
     * @param max     电影最大条数
     * @return
     */
    public List<LoldyttPojo> getResource(String keyword, int max) {
        List<LoldyttPojo> loldyttPojos = new ArrayList<>();
        // 获取电影搜索列表
        Map<String, String> movies = getMovieList(keyword, max);
        if (movies != null && movies.size() != 0) {
            for (String key : movies.keySet()) {
                // 获取电影下载链接
                LoldyttPojo loldyttPojo = getMovie(key, movies.get(key));
                if (loldyttPojo != null) {
                    loldyttPojos.add(loldyttPojo);
                }
            }
            return loldyttPojos;
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
        Document doc = null;
        String url = BASE_URL + "/search/index.asp";
        String data = null;
        try {
            data = "keyword=" + URLEncoder.encode(keyword, "gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 获取电影搜索网页
        doc = postRequest(url, data);
        // 解析搜索页面，获取每部电影的链接
        try {
            Elements elements = doc.select("div.solb");
            Elements movieList = elements.select("ol a");
            if (movieList.size() != 0) {
                logger.info("(LOL电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).text();
                    String movieUrl = movieList.get(i).attr("href");
                    movies.put(movieName, movieUrl);
                    logger.info("(LOL电影天堂)获取电影 " + movieName + " ...keyword: " + keyword);
                }
                return movies;
            }
            else{
                logger.info("(LOL电影天堂)获取电影搜索列表失败...keyword: " + keyword);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    public LoldyttPojo getMovie(String movieName, String movieUrl) {
        LoldyttPojo loldyttPojo =  new LoldyttPojo();
        loldyttPojo.setMovieName(movieName);
        loldyttPojo.setMovieUrl(movieUrl);
        List<Resource> thunder = new ArrayList<>();
        List<Resource> magnet = new ArrayList<>();
        Document doc = getRequest(movieUrl);
        // 解析网页，获取下载链接
        try {
            Element movieAll = doc.getElementById("liebiao");
            Elements movieList = movieAll.select("div.con4 li a");
            if (movieList.size() != 0 ) {
                logger.info("(LOL电影天堂)获取电影资源成功,共 " + movieList.size() + " 条...movieName: " + movieName);
                // 解析迅雷链接和磁力链接
                parseResource(movieList, thunder, magnet);
                loldyttPojo.setThunder(thunder);
                loldyttPojo.setMagnet(magnet);
                return loldyttPojo;
            } else {
                logger.info("(LOL电影天堂)获取电影资源失败...movieName: " + movieName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        LoldyttResource x = new LoldyttResource();
        List<LoldyttPojo> pojos = x.getResource("星际穿越", 3);
        for(LoldyttPojo i : pojos){
            System.out.println(i.getMovieName());
            for(Resource j : i.getMagnet()){
                System.out.println(j.getResourceName()+":"+j.getResourceUrl());
            }
        }
    }

}
