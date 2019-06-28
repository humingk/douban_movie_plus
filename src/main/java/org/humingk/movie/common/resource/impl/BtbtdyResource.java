package org.humingk.movie.common.resource.impl;

import org.humingk.movie.common.resource.movieResource;
import org.humingk.movie.common.resource.pojo.BtbtdyPojo;
import org.humingk.movie.common.resource.pojo.Resource;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取Btbtdy 资源信息
 *
 * @author lzx
 */
public class BtbtdyResource extends movieResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 基本 url
     */
    private static final String BASE_URL = "http://www.btbtdy.me";
    /**
     * 解析url中的ID
     */
    private static final Pattern URL_ID = Pattern.compile("(\\d+)");

    /**
     * 获取所有资源信息
     *
     * @param keyword
     * @param max     电影最大条数
     * @return
     */
    public List<BtbtdyPojo> getResource(String keyword, int max) {
        List<BtbtdyPojo> btbtdyPojos = new ArrayList<>();
        // 获取电影搜索列表
        Map<String, String> movies = getMovieList(keyword, max);
        if (movies != null && movies.size() != 0) {
            for (String key : movies.keySet()) {
                // 获取电影下载链接
                BtbtdyPojo btbtdyPojo = getMovie(key, movies.get(key));
                if (btbtdyPojo != null) {
                    btbtdyPojos.add(btbtdyPojo);
                }
            }
            return btbtdyPojos;
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
        String url = BASE_URL + "/search/" + keyword + ".html";
        // 获取电影搜索网页
        Document doc = getRequest(url);
        // 解析搜索页面，获取每部电影的链接
        try {
            Elements elements = doc.getElementsByClass("list_so");
            Elements movieList = elements.select("dd.lf a");
            if (movieList.size() != 0) {
                logger.info("(BT电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).attr("title");
                    // 用正则表达式匹配url中的电影ID
                    Matcher matcher = URL_ID.matcher(movieList.get(i).attr("href"));
                    if (matcher.find()) {
                        int movieId = Integer.valueOf(matcher.group(0));
                        // 拼接新的电影url
                        String movieUrl = BASE_URL + "/vidlist/" + movieId + ".html";
                        movies.put(movieName, movieUrl);
                        logger.info("(BT电影天堂)获取电影 " + movieName + " ...url: " + movieUrl);
                    }
                }
                return movies;
            }
            else{
                logger.info("(BT电影天堂)获取电影搜索列表失败...keyword: " + keyword);
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
    public BtbtdyPojo getMovie(String movieName, String movieUrl) {
        BtbtdyPojo btbtdyPojo =  new BtbtdyPojo();
        btbtdyPojo.setMovieName(movieName);
        btbtdyPojo.setMovieUrl(movieUrl);
        Document doc = getRequest(movieUrl);
        try {
            //不同清晰度的下载链接列表
            List<Resource> p720 = new ArrayList<>();
            List<Resource> p1080 = new ArrayList<>();
            List<Resource> k4 = new ArrayList<>();
            List<Resource> blue = new ArrayList<>();
            List<Resource> ed2k = new ArrayList<>();
            List<Resource> unknown = new ArrayList<>();
            // 解析电影网页，获取资源清晰度类别
            Elements typeList = doc.select("div.p_list");
            for(Element type:typeList){
                String resourceType = type.select("h2").text();
                // 获取资源名称和下载链接，它们的a标签是分开的，故分别获取两个列表
                Elements nameList = type.select("a[class^=ico]");
                Elements urlList = type.select("a.d1");
                List<Resource> resources = new ArrayList<>();
                if(nameList.size() != 0 && urlList.size() != 0) {
                    logger.info("(BT电影天堂)获取电影资源成功,共 " + nameList.size() + " 条...movieName: " + movieName + "...type:" + resourceType);
                    for(int i = 0; i<nameList.size() && i<urlList.size(); i++){
                        String resourceUrl = urlList.get(i).attr("href");
                        String resourceName = nameList.get(i).attr("title");
                        Resource resource = new Resource(resourceName, resourceUrl);
                        resources.add(resource);
                        logger.info("获取电影资源...resourceName: " + resourceName);
                        logger.info("获取电影资源...resourceUrl: " + resourceUrl);
                    }
                    // 根据资源的清晰度，对链接分类
                    switch (resourceType) {
                        case BtbtdyPojo.P720_TYPE:
                            p720.addAll(resources);
                            break;
                        case BtbtdyPojo.P1080_TYPE:
                            p1080.addAll(resources);
                            break;
                        case BtbtdyPojo.ED2K_TYPE:
                            ed2k.addAll(resources);
                            break;
                        case BtbtdyPojo.K4_TYPE:
                            k4.addAll(resources);
                            break;
                        case BtbtdyPojo.BLUE_TYPE:
                            blue.addAll(resources);
                            break;
                        default:
                            unknown.addAll(resources);
                    }
                }
                else {
                    logger.info("(BT电影天堂)获取电影资源失败...movieName: " + movieName);
                }
            }
            btbtdyPojo.setP720(p720);
            btbtdyPojo.setP1080(p1080);
            btbtdyPojo.setEd2k(ed2k);
            btbtdyPojo.setK4(k4);
            btbtdyPojo.setBlue(blue);
            btbtdyPojo.setUnknown(unknown);
            return btbtdyPojo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        BtbtdyResource x = new BtbtdyResource();
        List<BtbtdyPojo> pojos = x.getResource("蜘蛛侠", 3);
        for(BtbtdyPojo i : pojos){
            System.out.println(i.getMovieName());
            for(Resource j : i.getP720()){
                System.out.println(j.getResourceName()+":"+j.getResourceUrl());
            }
            for(Resource j : i.getP1080()){
                System.out.println(j.getResourceName()+":"+j.getResourceUrl());
            }
        }

    }
}
