package org.humingk.movie.common.resource.client;

import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.type.ClientType;
import org.humingk.movie.common.resource.type.ResourceType;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
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
     * 通过关键字获取电影搜索结果
     *
     * @param keyword 搜索关键字
     * @param max     每个网站电影搜索结果最大数
     */
    @Override
    public List<Search> getMovieSearch(String keyword, int max) {
        List<Search> result = null;
        String url = BASE_URL + "/search/" + keyword + ".html";
        try {
            // 获取电影搜索网页
            Document doc = jsoupRequest(url, Connection.Method.GET);
            Elements elements = doc.getElementsByClass("list_so");
            Elements movieList = elements.select("dd.lf a");
            if (movieList.size() != 0) {
                result = new ArrayList<>();
                // 解析搜索页面，获取每部电影的链接
                for (int i = 0; i < max && i < movieList.size(); i++) {
                    String movieName = movieList.get(i).attr("title");
                    // 用正则表达式匹配url中的电影ID
                    Matcher matcher = URL_ID.matcher(movieList.get(i).attr("href"));
                    if (matcher.find()) {
                        int movieId = Integer.valueOf(matcher.group(0));
                        // 拼接新的电影url
                        String movieUrl = BASE_URL + "/vidlist/" + movieId + ".html";
                        result.add(new Search(keyword, movieName, movieUrl, ClientType.CLIENT_BTBTDY));
                    }
                }
                logger.debug("(BT电影天堂)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("(BT电影天堂)获取电影搜索列表失败...keyword: " + keyword + " searchUrl: " + url, e);
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
        String keyword = search.getKeyword();
        try {
            Document doc = jsoupRequest(search.getMovieUrl(), Connection.Method.GET);
            if (doc != null) {
                result = new ArrayList<>();
                // 解析电影网页
                Elements typeList = doc.select("div.p_list");
                for (Element type : typeList) {
                    String resourceType = type.select("h2").text();
                    Elements nameList = type.select("a[class^=ico]");
                    Elements urlList = type.select("a.d1");
                    if (nameList.size() != 0 && urlList.size() != 0) {
                        for (int i = 0; i < nameList.size() && i < urlList.size(); i++) {
                            String resourceUrl = urlList.get(i).attr("href");
                            String resourceName = nameList.get(i).attr("title");
                            // 资源表
                            Resource resource = new Resource(resourceName, resourceUrl);
                            resource.setKeyword(keyword);
                            resource.setClientType(ClientType.CLIENT_BTBTDY);
                            int resourceTypeId = ResourceType.RESOURCE_UNKNOWN;
                            // 根据资源的清晰度，对链接分类
                            switch (resourceType) {
                                case "720p下载地址":
                                    resourceTypeId = ResourceType.RESOURCE_P720;
                                    break;
                                case "1080p下载地址":
                                    resourceTypeId = ResourceType.RESOURCE_P1080;
                                    break;
                                case "ED2K下载地址":
                                    resourceTypeId = ResourceType.RESOURCE_ED2K;
                                    break;
                                case "4k下载地址":
                                    resourceTypeId = ResourceType.RESOURCE_K4;
                                    break;
                                case "蓝光原盘下载地址":
                                    resourceTypeId = ResourceType.RESOURCE_BLUE;
                                    break;
                            }
                            resource.setResourceType(resourceTypeId);
                            result.add(resource);
                        }
                    }
                }
                logger.debug("(BT电影天堂)获取电影资源成功...keyword: " + search.getKeyword()
                        + " size: " + typeList.size()
                        + " movieName: " + search.getMovieName() +
                        " movieUrl: " + search.getMovieUrl());
            }
        } catch (Exception e) {
            logger.error("(BT电影天堂)获取电影资源失败...keyword: " + search.getKeyword()
                    + " movieName: " + search.getMovieName() +
                    " movieUrl: " + search.getMovieUrl(), e);
        }
        return result;
    }
}
