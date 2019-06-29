package org.humingk.movie.common.movieResource;

import org.humingk.movie.common.movieResource.resource.Resource;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取电影资源抽象类
 *
 * @author lzx
 * @author humingk
 */
public abstract class AbstractMovieResourceAdapter implements MovieResourceTarget {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 以thunder开头
     */
    private static final String THUNDER_START = "thunder";
    /**
     * 以magnet开头
     */
    private static final String MAGNET_START = "magnet";

    /**
     * 请求头
     */
    private static final Map<String, String> headers = new HashMap<String, String>() {{
        put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        put("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
        put("content-type", "application/x-www-form-urlencoded");
    }};

    /**
     * 通过搜索关键字获取资源列表
     *
     * @param keyword 搜索关键字
     * @param max     电影最大条数
     * @return
     */
    @Override
    public <T> List<T> getResource(String keyword, int max) {
        List<T> result = null;
        // 获取电影搜索列表
        Map<String, String> movies = getMovieList(keyword, max);
        if (movies != null && movies.size() != 0) {
            result = new ArrayList<>();
            for (String key : movies.keySet()) {
                // 获取电影下载链接
                T movie = getMovie(key, movies.get(key));
                if (movie != null) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    /**
     * 解析 MovieAllResource 为迅雷链接与磁力链接
     *
     * @param elements
     * @param thunders
     * @param magnets
     */
    @Override
    public void parseResource(Elements elements, List<Resource> thunders, List<Resource> magnets) {
        for (int i = 0; i < elements.size(); i++) {
            String resourceName = elements.get(i).attr("title");
            String resourceUrl = elements.get(i).attr("href");
            Resource resource = new Resource(resourceName, resourceUrl);
            if (resourceUrl.startsWith(THUNDER_START)) {
                thunders.add(resource);
            } else if (resourceUrl.startsWith(MAGNET_START)) {
                magnets.add(resource);
            }
            logger.debug("获取电影资源...resourceName: " + resourceName);
            logger.debug("获取电影资源...resourceUrl: " + resourceUrl);
        }
    }

    /**
     * 1. Jsoup方式请求
     *
     * @param url    页面链接
     * @param method 请求类型 默认get
     */
    @Override
    public Document jsoupRequest(String url, Connection.Method method) {
        Document doc = null;
        // 获取网页
        try {
            doc = Jsoup.connect(url)
                    .header("accept", headers.get("accept"))
                    .header("user-agent", headers.get("user-agent"))
                    .header("content-type", headers.get("content-type"))
                    .method(method)
                    .get();
        } catch (Exception e) {
            logger.error("", e);
        }
        return doc;
    }

    /**
     * 2. HttpURLConnection请求方式
     *
     * @param url    页面链接
     * @param data   提交的数据
     * @param method 请求类型 默认get
     */
    @Override
    public Document httpUrlConnRequest(String url, String data, String method) {
        Document doc = null;
        try {
            OutputStream outStream;
            OutputStreamWriter out;
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 提交模式
            conn.setRequestMethod(method);
            conn.addRequestProperty("accept", headers.get("accept"));
            conn.addRequestProperty("user-Agent", headers.get("user-Agent"));
            conn.addRequestProperty("content-type", headers.get("content-type"));
            outStream = conn.getOutputStream();
            out = new OutputStreamWriter(outStream);
            //参数输出
            out.write(data);
            // flush输出流的缓冲
            out.flush();
            doc = Jsoup.parse(conn.getInputStream(), "GBK", url);
        } catch (Exception e) {
            logger.error("", e);
        }
        return doc;
    }
}
