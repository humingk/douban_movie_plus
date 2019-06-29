package org.humingk.movie.common;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取 loldytt 资源信息
 *
 * @author humingk
 */
public class ResourceLoldytt {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 基本 url
     */
    private static final String BASE_URL = "http://www.loldytt.tv";
    /**
     * 是否以thunder开头
     */
    private static final String IS_THUNDER = "thunder";
    /**
     * 是否以magnet开头
     */
    private static final String IS_MAGNET = "magnet";

    /**
     * 获取所有资源信息
     *
     * @param keyword
     * @param max     电影最大条数
     * @return
     */
    public List<LoldyttResource> getResource(String keyword, int max) {
        List<LoldyttResource> loldyttResources = new ArrayList<>();
        Map<String, String> movies = getMovieList(keyword, max);
        if (movies != null && movies.size() != 0) {
            for (String key : movies.keySet()) {
                LoldyttResource loldyttResource = getMovie(key, movies.get(key));
                if (loldyttResource != null) {
                    loldyttResources.add(loldyttResource);
                }
            }
            return loldyttResources;
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
    private Map<String, String> getMovieList(String keyword, int max) {
        Map<String, String> movies = new LinkedHashMap();
        Document doc = null;
        // 获取网页
        try {
            String url = BASE_URL + "/search/index.asp?keyword=" + URLEncoder.encode(keyword, "gb2312");
            doc = Jsoup.connect(url)
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .header("referer", BASE_URL + "/")
                    .method(Connection.Method.POST)
                    .post();
        } catch (Exception e) {
            logger.error("",e);
        }
        try {
            Elements elements = doc.select("div.solb");
            Elements movieList = elements.select("ol a");
            if (movieList.size() != 0) {
                logger.info("(LOL电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
                for (int i = 0; i < movieList.size() && i < max; i++) {
                    String movieName = movieList.get(i).text();
                    String movieUrl = movieList.get(i).attr("href");
                    movies.put(movieName, movieUrl);
                    logger.info("(LOL电影天堂)获取电影 " + movieName + " ...keyword: " + keyword);
                }
                return movies;
            } else {
                logger.info("(LOL电影天堂)获取电影搜索列表失败...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        return null;
    }

    private LoldyttResource getMovie(String movieName, String movieUrl) {
        LoldyttResource loldyttResource = new LoldyttResource();
        loldyttResource.setMovieName(movieName);
        loldyttResource.setMovieUrl(movieUrl);
        List<Resource> thunders = null;
        List<Resource> magnets = null;
        Document doc = null;
        // 获取网页
        try {
            doc = Jsoup.connect(movieUrl)
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .header("referer", BASE_URL + "/")
                    .method(Connection.Method.GET)
                    .get();
        } catch (Exception e) {
            logger.error("",e);
        }
        // 解析网页
        try {
            thunders = new ArrayList<>();
            magnets = new ArrayList<>();
            Element movieAll = doc.getElementById("liebiao");
            Elements movieList1 = movieAll.select("div#jishu a");
            Elements movieList2 = movieAll.select("div#ljishu a");
            if (movieList1.size() != 0 || movieList2.size() != 0) {
                logger.info("(LOL电影天堂)获取电影资源成功,共 " + (movieList1.size() + movieList2.size()) + " 条...movieName: " + movieName);
                parseResource(movieList1, thunders, magnets);
                parseResource(movieList2, thunders, magnets);
                loldyttResource.setThunder(thunders);
                loldyttResource.setMagnet(magnets);
                return loldyttResource;
            } else {
                logger.info("(LOL电影天堂)获取电影资源失败...movieName: " + movieName);
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        return null;
    }

    /**
     * 解析 resource
     *
     * @param elements
     * @param thunders
     * @param magnets
     */
    private void parseResource(Elements elements, List<Resource> thunders, List<Resource> magnets) {
        // 最后一个是下载所有选择的文件 故 -1
        for (int i = 0; i < elements.size() - 1; i++) {
            String resourceName = elements.get(i).attr("title");
            String resourceUrl = elements.get(i).attr("href");
            Resource resource = new Resource();
            resource.setResourceName(resourceName);
            resource.setResourceUrl(resourceUrl);
            if (resourceUrl.startsWith(IS_THUNDER)) {
                thunders.add(resource);
            } else if (resourceUrl.startsWith(IS_MAGNET)) {
                magnets.add(resource);
            }
            logger.info("(LOL电影天堂)获取电影资源...resourceName: " + resourceName);
            logger.info("(LOL电影天堂)获取电影资源...resourceUrl: " + resourceUrl);
        }
    }

    public static void main(String[] args) {
        ResourceLoldytt r = new ResourceLoldytt();
        r.getResource("星际穿越", 3);
    }
}
