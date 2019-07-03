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

import java.util.List;

/**
 * 获取 xl720 资源信息
 *
 * @author lzx
 */
public class Xl720Client extends AbstractMovieResourceAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 基本 url
     */
    private static final String BASE_URL = "https://www.xl720.com";

    /**
     * 通过关键字获取电影搜索结果
     *
     * @param keyword 搜索关键字
     * @param max     每个网站电影搜索结果最大数
     */
    @Override
    public List<Search> getMovieSearch(String keyword, int max) {
        List<Search> result = null;
        String url = BASE_URL + "/?s=" + keyword;
        try {
            // 获取电影搜索网页
            Document doc = jsoupRequest(url, Connection.Method.GET);
            // 解析搜索页面，获取每部电影的链接
            Elements elements = doc.getElementsByClass("entry-title  postli-1");
            Elements movieList = elements.select("a");
            if (movieList.size() != 0) {
                // 解析搜索页面
                result = parseSearch(keyword, ClientType.CLIENT_XL720, max, "fullpath", movieList);
                logger.debug("(Xl720)获取电影搜索列表成功,共 " + movieList.size() + " 条...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("(Xl720)获取电影搜索列表失败...keyword: " + keyword + " searchUrl: " + url, e);
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
            Elements movieList1 = doc.select("div.down_btn a");
            Elements movieList2 = doc.select("div.ztxt a");
            if (movieList1.size() != 0 || movieList2.size() != 0) {
                // 解析迅雷链接和磁力链接
                result = parseMagnetAndThunder(search.getKeyword(), ClientType.CLIENT_XL720, movieList1);
                result.addAll(parseMagnetAndThunder(search.getKeyword(), ClientType.CLIENT_XL720, movieList2));
                logger.debug("(Xl720)获取电影资源成功...keyword: " + search.getKeyword()
                        + " size: " + (movieList1.size() + movieList2.size())
                        + " movieName: " + search.getMovieName() +
                        " movieUrl: " + search.getMovieUrl());
            }
        } catch (Exception e) {
            logger.error("(Xl720)获取电影资源失败...keyword: " + search.getKeyword()
                    + " movieName: " + search.getMovieName() +
                    " movieUrl: " + search.getMovieUrl(), e);
        }
        return result;
    }
}
