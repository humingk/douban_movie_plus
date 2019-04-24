package org.humingk.movie.common;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取 loldytt 资源信息
 *
 * @author humin
 */
public class ResourceLoldytt2 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 基本 url
     */
    private static final String BASE_URL = "http://www.loldyttw.com";

    // movie list xpath ------------- start

    /**
     * 搜索页面 电影列表根目录
     */
    public static final String XPATH_MOVIES_LIST = "//div[@class='solb']/ol";
    /**
     * 电影列表 电影名称
     */
    public static final String XPATH_MOVIES_NAME = "./label/a/text()";
    /**
     * 电影列表 电影 url
     */
    public static final String XPATH_MOVIES_URL = "./label/a/@href";

    // movie list xpath ------------- end

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
//        for (String key : movies.keySet()) {
//            LoldyttResource loldyttResource = getMovie(key, movies.get(key));
//            if (loldyttResource != null) {
//                loldyttResources.add(loldyttResource);
//            }
//        }
        return loldyttResources;
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
        String url = BASE_URL + "/e/search/index.php";
        StringBuilder html = new StringBuilder();
        Document doc=null;
        // 获取网页
        try {
            doc = Jsoup.connect(url)
                    .header("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                    .header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36")
                    .header("content-type","application/x-www-form-urlencoded")
                    .header("referer",BASE_URL + "/")
                    .cookie("cookie","selxulastsearchtime=" + (System.currentTimeMillis() - 300 * 60 * 1000) / 1000)
                    .data("show","title%2Cnewstext")
                    .data("tbname","download")
                    .data("tempid","1")
//                    .data("keyboard",URLEncoder.encode(keyword, "gb2312"))
                    .data("keyboard","%D0%C7%BC%CA")
                    .data("submit","%CB%D1%CB%F7%D2%BB%CF%C2")
                    .method(Connection.Method.POST)
                    .post();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(doc.body().html());
        System.out.println("================");

        TagNode tagNode = new HtmlCleaner().clean(String.valueOf(doc));

        // 解析网页
        try {
            // 初始化 document xpath
            org.w3c.dom.Document document = new DomSerializer(new CleanerProperties()).createDOM(tagNode);
            XPath xPath = XPathFactory.newInstance().newXPath();
            // 电影列表

            Object result = xPath.evaluate(XPATH_MOVIES_LIST, document, XPathConstants.NODESET);
            if (result instanceof NodeList) {
                NodeList nodeListForMovieList = (NodeList) result;
                int movieSum = nodeListForMovieList.getLength();
                if (movieSum != 0) {
                    logger.info("(LOL电影天堂)获取电影搜索列表成功,共 " + movieSum + " 条...keyword: " + keyword);
                    for (int i = 0; i < max; i++) {
                        Node node = nodeListForMovieList.item(i);
                        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            try {
                                String name = (String) xPath.evaluate(XPATH_MOVIES_NAME, element, XPathConstants.STRING);
                                System.out.println("name "+name);

                                String tttt=(String) xPath.evaluate("//div[@class='solb']/ol[2]/label/a/text()",document,XPathConstants.STRING);
                                System.out.println("tttt "+tttt);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return movies;
                } else {
                    logger.info("(LOL电影天堂)获取电影搜索列表失败...keyword: " + keyword);
                }
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private LoldyttResource getMovie(String name, String url) {

        return null;
    }

    public static void main(String[] args) {
        ResourceLoldytt2 r = new ResourceLoldytt2();
        r.getResource("星际", 3);
    }
}
