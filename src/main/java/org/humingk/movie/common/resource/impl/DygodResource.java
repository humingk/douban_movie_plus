package org.humingk.movie.common.resource.impl;

import org.humingk.movie.common.resource.movieResource;
import org.humingk.movie.common.resource.pojo.DygodPojo;
import org.humingk.movie.common.resource.pojo.Resource;
import org.jsoup.nodes.Document;
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
 * 获取 dygod 资源信息
 *
 * @author lzx
 */
public class DygodResource extends movieResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String BASE_URL = "https://www.dygod.net";
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
        String url = BASE_URL + "/e/search/index.php";
        String data = null;
        try {
            data = "show=title&tempid=1&keyboard=" + URLEncoder.encode(keyword, "gb2312") + "&Submit=%C1%A2%BC%B4%CB%D1%CB%F7";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Document doc = postRequest(url, data);
        Elements movieList = doc.select("table.tbspan a");
        try {
            if (movieList.size() != 0) {
                logger.info("(电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).attr("title");
                    String movieUrl = BASE_URL + movieList.get(i).attr("href");
                    movies.put(movieName, movieUrl);
                    logger.info("(电影天堂)获取电影 " + movieName + " ...url: " + movieUrl);
                }
                return movies;
            }
            else{
                logger.info("(电影天堂)获取电影搜索列表失败...keyword: " + keyword);
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
    public DygodPojo getMovie(String movieName, String movieUrl) {
        DygodPojo dygodPojo =  new DygodPojo();
        dygodPojo.setMovieName(movieName);
        dygodPojo.setMovieUrl(movieUrl);
        Document doc = getRequest(movieUrl);
        // 解析网页
        try {
            List<Resource> thunder = new ArrayList<>();
            List<Resource> magnet = new ArrayList<>();
            Elements movieList = doc.select("div#Zoom table a");
            if (movieList.size() != 0 ) {
                logger.info("(电影天堂)获取电影资源成功,共 " + movieList.size() + " 条...movieName: " + movieName);
                parseResource(movieList, thunder, magnet);
                dygodPojo.setThunder(thunder);
                dygodPojo.setMagnet(magnet);
                return dygodPojo;
            } else {
                logger.info("(电影天堂)获取电影资源失败...movieName: " + movieName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有资源信息
     *
     * @param keyword
     * @param max     电影最大条数
     * @return
     */
    public List<DygodPojo> getResource(String keyword, int max) {
        List<DygodPojo> dygodPojos = new ArrayList<>();
        Map<String, String> movies = getMovieList(keyword, max);
        if (movies != null && movies.size() != 0) {
            for (String key : movies.keySet()) {
                DygodPojo dygodPojo = getMovie(key, movies.get(key));
                if (dygodPojo != null) {
                    dygodPojos.add(dygodPojo);
                }
            }
            return dygodPojos;
        }
        return null;
    }

    public static void main(String[] args) {
        DygodResource x = new DygodResource();
        List<DygodPojo> pojos = x.getResource("权力的游戏", 3);
        for(DygodPojo i : pojos){
            System.out.println(i.getMovieName());
            for(Resource j : i.getThunder()){
                System.out.println(j.getResourceName()+":"+j.getResourceUrl());
            }
        }
    }
}
