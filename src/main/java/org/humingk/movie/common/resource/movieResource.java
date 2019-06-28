package org.humingk.movie.common.resource;

import org.humingk.movie.common.resource.pojo.Resource;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 获取电影资源的父类
 *
 * @author lzx
 */
public abstract class movieResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 是否以thunder开头
     */
    private static final String IS_THUNDER = "thunder";
    /**
     * 是否以magnet开头
     */
    private static final String IS_MAGNET = "magnet";

    public abstract Map<String, String> getMovieList(String keyword, int max);

    /**
     * 解析 resource 为迅雷链接或磁力链接
     *
     * @param elements
     * @param thunders
     * @param magnets
     */
    public final void parseResource(Elements elements, List<Resource> thunders, List<Resource> magnets){
        for (int i = 0; i < elements.size(); i++) {
            String resourceName = elements.get(i).attr("title");
            String resourceUrl = elements.get(i).attr("href");
            Resource resource = new Resource(resourceName, resourceUrl);
            if (resourceUrl.startsWith(IS_THUNDER)) {
                thunders.add(resource);
            } else if (resourceUrl.startsWith(IS_MAGNET)) {
                magnets.add(resource);
            }
            logger.info("获取电影资源...resourceName: " + resourceName);
            logger.info("获取电影资源...resourceUrl: " + resourceUrl);
        }
    }

    /**
     * 发送get请求获取页面
     *
     * @param url   页面链接
     */
    public final Document getRequest(String url){
        Document doc;
        // 获取网页
        try {
            doc = Jsoup.connect(url)
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .method(Connection.Method.GET)
                    .get();
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送post请求获取页面
     *
     * @param url   页面链接
     * @param data   提交的数据
     */
    public final Document postRequest(String url, String data){
        try {
            OutputStream outStream = null;
            OutputStreamWriter out = null;
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");// 提交模式
            conn.addRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            conn.addRequestProperty("content-type", "application/x-www-form-urlencoded");
            conn.addRequestProperty("user-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            outStream = conn.getOutputStream();
            out = new OutputStreamWriter(outStream);
            //参数输出
            out.write(data);
            // flush输出流的缓冲
            out.flush();
            Document doc = Jsoup.parse(conn.getInputStream(), "GBK", url);
            return doc;
        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
