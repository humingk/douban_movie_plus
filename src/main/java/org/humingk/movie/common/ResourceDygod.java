package org.humingk.movie.common;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * 获取电影天堂资源
 *
 * @author humin
 */
public class ResourceDygod {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 电影天堂
     * .com太慢了
     */
    public static final String BASE_URL = "https://www.dygod.net";

    /**
     * 是否搜索到电影
     */
    public static final String XPATH_IS_SEARCHED = "//div/@id";

    /**
     * 电影列表
     */
    public static final String XPATH_MOVIE_LIST = "//div[@class='co_content8']//ul";

    /**
     * 电影 url
     */
    public static final String XPATH_MOVIE_URL = ".//a";

    /**
     * 电影 title
     */
    public static final String XPATH_MOVIE_TITLE = ".//a/@href";

    /**
     * 获取资源
     *
     * @param keyword
     * @return
     */
    public List<String> getResource(String keyword) {
        String url = BASE_URL + "/e/search/index.php";

        StringBuilder html = new StringBuilder();
        // PrintWriter以字符为单位，支持汉字
        PrintWriter out = null;
        // OutputStreamWriter以字节为单位，不支持汉字
        OutputStreamWriter out2 = null;
        BufferedReader in = null;
        try {
            URL realURL = new URL(url);

            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            // 发送POST请求
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            // 请求头
//            connection.setRequestProperty("cookie","pescdlastsearchtime=1555937235");
            connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            connection.setRequestProperty("accept-encoding", "gzip, deflate, br");
            connection.setRequestProperty("accept-language", "zh-CN,zh;q=0.9,en;q=0.8");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36");
            connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("origin", "https://www.dygod.net");
            connection.setRequestProperty("referer", "https://www.dygod.net/index.html");
            connection.setRequestProperty("cookie", "selxulastsearchtime=" + (System.currentTimeMillis() - 300 * 60 * 1000) / 1000);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(connection.getOutputStream());
//            String resParm="show=title%2Csmalltext&tempid=1&keyboard="+ URLEncoder.encode(keyword,"gb2312") +"&Submit=%C1%A2%BC%B4%CB%D1%CB%F7\n";
            String resParm = "show=title&tempid=1&keyboard=" + URLEncoder.encode(keyword, "gb2312") + "&Submit=%C1%A2%BC%B4%CB%D1%CB%F7";
            System.out.println(resParm);
            // 发送请求参数
            out.print(resParm);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gb2312"));
            String line;
            while ((line = in.readLine()) != null) {
                html.append(line);
            }
            System.out.println(html.toString());
            System.out.println("==================");
            // 解析网页
            TagNode tagNode = new HtmlCleaner().clean(html.toString());

            // 初始化 document xpath
            Document document = new DomSerializer(new CleanerProperties()).createDOM(tagNode);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // 判断是否有结果
            String isSearched = (String) xPath.evaluate(XPATH_IS_SEARCHED, document, XPathConstants.STRING);
            String test = (String) xPath.evaluate("//*[@id='header']/div/div[3]/div[2]/div[1]/div[5]/div[2]/ul/table[1]/tbody/tr[2]/td[2]/b/a/text()", document, XPathConstants.STRING);
            System.out.println("================");
            System.out.println(test);
            if ("header".equals(isSearched)) {
                logger.info("(电影天堂)搜索到结果...keyword: " + keyword);
                int movieSum;

                Object resultForMovie = xPath.evaluate(XPATH_MOVIE_LIST, document, XPathConstants.NODESET);
                if (resultForMovie instanceof NodeList) {
                    NodeList nodeListForMovie = (NodeList) resultForMovie;
                    for (int i = 0; i < nodeListForMovie.getLength(); i++) {
                        Node node = nodeListForMovie.item(i);
                        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            try {
                                Node nodeForName = (Node) xPath.evaluate(XPATH_MOVIE_TITLE, element, XPathConstants.NODE);
                                String movieName = nodeForName.getNodeValue();
                                Node nodeForUrl = (Node) xPath.evaluate(XPATH_MOVIE_URL, element, XPathConstants.NODE);
                                String movieUrl = BASE_URL + nodeForUrl.getNodeValue();
                                logger.info("movieName: " + movieName);
                                logger.info("movieUrl: " + movieUrl);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            } else {
                logger.info("(电影天堂)搜索不到结果...keyword: " + keyword);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ResourceDygod resourceDygod = new ResourceDygod();
        resourceDygod.getResource("我");
    }
}