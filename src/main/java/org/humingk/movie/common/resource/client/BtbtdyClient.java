package org.humingk.movie.common.resource.client;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.common.resource.pojo.Resource;
import org.humingk.movie.common.resource.pojo.site.BtbtdyResource;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取Btbtdy资源
 *
 * @author lzx
 * @author humingk
 */
public class BtbtdyClient extends AbstractMovieResourceAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 网站 url
     */
    private static final String BASE_URL = "http://www.btbtdy.me";
    /**
     * 解析url中的ID
     */
    private static final Pattern URL_ID = Pattern.compile("(\\d+)");

    /**
     * 获取电影搜索列表
     *
     * @param keyword 搜索关键字
     * @param max     搜索结果保留最大数
     */
    @Override
    public MovieMap<BtbtdyClient> getMovieMap(String keyword, int max) {
        MovieMap<BtbtdyClient> result = null;
        List<Movie> movies = null;
        String url = BASE_URL + "/search/" + keyword + ".html";
        try {
            // 获取电影搜索网页
            Document doc = jsoupRequest(url, Connection.Method.GET);
            // 解析搜索页面，获取每部电影的链接
            Elements elements = doc.getElementsByClass("list_so");
            Elements movieList = elements.select("dd.lf a");
            if (movieList.size() != 0) {
                result = new MovieMap<>(keyword, BtbtdyClient.class);
                movies = new ArrayList<>();
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).attr("title");
                    // 用正则表达式匹配url中的电影ID
                    Matcher matcher = URL_ID.matcher(movieList.get(i).attr("href"));
                    if (matcher.find()) {
                        int movieId = Integer.valueOf(matcher.group(0));
                        // 拼接新的电影url
                        String movieUrl = BASE_URL + "/vidlist/" + movieId + ".html";
                        movies.add(new Movie(movieName, movieUrl));
                        logger.debug("(BT电影天堂)获取电影 " + movieName + " ...url: " + movieUrl);
                    }
                }
                result.setMovies(movies);
                logger.debug("(BT电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
            } else {
                logger.debug("(BT电影天堂)获取电影搜索列表失败...keyword: " + keyword);
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
    public BtbtdyResource getMovie(Movie moviePojo) {
        String movieName = moviePojo.getMovieName();
        String movieUrl = moviePojo.getMovieUrl();
        BtbtdyResource result = null;
        try {
            Document doc = jsoupRequest(movieUrl, Connection.Method.GET);
            if (doc != null) {
                result = new BtbtdyResource();
                result.setMovie(moviePojo);
                //不同清晰度的下载链接列表
                List<Resource> p720 = new ArrayList<>();
                List<Resource> p1080 = new ArrayList<>();
                List<Resource> k4 = new ArrayList<>();
                List<Resource> blue = new ArrayList<>();
                List<Resource> ed2k = new ArrayList<>();
                List<Resource> unknown = new ArrayList<>();
                // 解析电影网页，获取资源清晰度类别
                Elements typeList = doc.select("div.p_list");
                for (Element type : typeList) {
                    String resourceType = type.select("h2").text();
                    // 获取资源名称和下载链接，它们的a标签是分开的，故分别获取两个列表
                    Elements nameList = type.select("a[class^=ico]");
                    Elements urlList = type.select("a.d1");
                    List<Resource> resources = new ArrayList<>();
                    if (nameList.size() != 0 && urlList.size() != 0) {
                        for (int i = 0; i < nameList.size() && i < urlList.size(); i++) {
                            String resourceUrl = urlList.get(i).attr("href");
                            String resourceName = nameList.get(i).attr("title");
                            Resource resource = new Resource(resourceName, resourceUrl);
                            resources.add(resource);
                        }
                        logger.debug("(BT电影天堂)获取电影资源成功,共 " + nameList.size() + " 条...movieName: " + movieName + "...type:" + resourceType);
                        // 根据资源的清晰度，对链接分类
                        switch (resourceType) {
                            case BtbtdyResource.P720_TYPE:
                                p720.addAll(resources);
                                break;
                            case BtbtdyResource.P1080_TYPE:
                                p1080.addAll(resources);
                                break;
                            case BtbtdyResource.ED2K_TYPE:
                                ed2k.addAll(resources);
                                break;
                            case BtbtdyResource.K4_TYPE:
                                k4.addAll(resources);
                                break;
                            case BtbtdyResource.BLUE_TYPE:
                                blue.addAll(resources);
                                break;
                            default:
                                unknown.addAll(resources);
                        }
                    } else {
                        logger.debug("(BT电影天堂)获取电影资源失败...movieName: " + movieName);
                    }
                }
                result.setP720(p720);
                result.setP1080(p1080);
                result.setEd2k(ed2k);
                result.setK4(k4);
                result.setBlue(blue);
                result.setUnknown(unknown);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }
}
