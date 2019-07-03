package org.humingk.movie.common.resource;

import org.humingk.movie.common.resource.type.ResourceType;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
 * <p>
 * 子类必须实现的两个方法
 * <p>
 * 1. getMovieSearch() 获取电影搜索结果
 * <p>
 * 2. getMovieResource() 获取电影资源
 *
 * @author lzx
 * @author humingk
 */
public abstract class AbstractMovieResourceAdapter implements MovieResourceTarget {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Map<String, String> headers = new HashMap<String, String>() {{
        put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        put("content-type", "application/x-www-form-urlencoded");
        put("user-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
        put("Accept-Encoding", "gzip,deflate");
        put("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        put("Connection", "keep-alive");
    }};

    /**
     * 解析搜索页面
     *
     * @param keyword
     * @param clientType
     * @param max
     * @param base_url
     * @param elements
     * @return
     */
    @Override
    public List<Search> parseSearch(String keyword, int clientType, int max, String base_url, Elements elements) {
        List<Search> result = new ArrayList<>();
        for (int i = 0; i < max && i < elements.size(); i++) {
            String movieName = elements.get(i).attr("title");
            String movieUrl = null;
            if (base_url == "fullpath") {
                movieUrl = elements.get(i).attr("href");
            } else {
                movieUrl = base_url + elements.get(i).attr("href");
            }
            result.add(new Search(keyword, movieName, movieUrl, clientType));
        }
        logger.debug("获取电影搜索列表成功,clientType:" + clientType + " keyword: " + keyword + "size: " + elements.size());
        return result;
    }


    /**
     * 解析磁力资源和迅雷资源
     *
     * @param keywrod
     * @param clientType
     * @param elements
     * @return
     */
    @Override
    public List<Resource> parseMagnetAndThunder(String keywrod, int clientType, Elements elements) throws Exception {
        List<Resource> result = new ArrayList<>();
        for (Element element : elements) {
            String resourceName = element.attr("title");
            String resourceUrl = element.attr("href");
            Resource resource = new Resource(resourceName, resourceUrl);
            if (resourceUrl.startsWith("thunder")) {
                resource.setResourceType(ResourceType.RESOURCE_THUNDER);
            } else if (resourceUrl.startsWith("magnet")) {
                resource.setResourceType(ResourceType.RESOURCE_MAGNET);
            } else {
                resource.setResourceType(ResourceType.RESOURCE_UNKNOWN);
            }
            resource.setKeyword(keywrod);
            resource.setClientType(clientType);
            result.add(resource);
        }
        return result;
    }

    /**
     * 1. Jsoup方式请求
     *
     * @param url    页面链接
     * @param method 请求类型 默认get
     */
    @Override
    public Document jsoupRequest(String url, Connection.Method method) throws Exception {
        return Jsoup.connect(url)
                .header("accept", headers.get("accept"))
                .header("user-agent", headers.get("user-Agent"))
                .header("content-type", headers.get("content-type"))
                .header("Accept-Encoding", headers.get("Accept-Encoding"))
                .header("Accept-Language", headers.get("Accept-Language"))
                .header("Connection", headers.get("Connection"))
                .method(method)
                .get();
    }

    /**
     * 2. HttpURLConnection请求方式
     *
     * @param url    页面链接
     * @param data   提交的数据
     * @param method 请求类型 默认get
     */
    @Override
    public Document httpUrlConnRequest(String url, String data, String method) throws Exception {
        URL realUrl = new URL(url);
        // 打开和URL之间的连接
        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // 提交模式
        conn.setRequestMethod(method);
        conn.addRequestProperty("accept", headers.get("accept"));
        conn.addRequestProperty("content-type", headers.get("content-type"));
        conn.addRequestProperty("user-Agent", headers.get("user-Agent"));
        conn.addRequestProperty("Accept-Encoding", headers.get("Accept-Encoding"));
        conn.addRequestProperty("Accept-Language", headers.get("Accept-Language"));
        conn.addRequestProperty("Connection", headers.get("Connection"));
        OutputStream outStream = conn.getOutputStream();
        OutputStreamWriter out = new OutputStreamWriter(outStream);
        //参数输出
        out.write(data);
        // flush输出流的缓冲
        out.flush();
        return Jsoup.parse(conn.getInputStream(), "GBK", url);
    }
}
