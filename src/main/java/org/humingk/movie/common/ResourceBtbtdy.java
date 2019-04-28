package org.humingk.movie.common;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取Btbtdy 资源信息
 *
 * @author humin
 */
public class ResourceBtbtdy {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // xpath movie list ---------- start
    /**
     * 解析url中的ID
     */
    private static final Pattern URL_ID = Pattern.compile("(\\d+)");
    /**
     * 电影列表
     */
    private static final String XPATH_MOVIES = "//body//div/dl//dd";

    /**
     * 电影名称
     */
    private static final String XPATH_MOVIE_NAME = ".//a/@title";

    /**
     * 电影url
     */
    private static final String XPATH_MOVIE_URL = ".//a/@href";

    // xpath movie list ---------- end

    // xpath movie detail ---------- start
    /**
     * 资源列表
     */
    private static final String XPATH_MOVIES_RESOURCE_LIST = "//div[@class='p_list']";
    /**
     * 资源种类标题
     */
    private static final String XPATH_MOVIES_RESOURCE_TITLE = "./h2/text()";
    /**
     * 资源种类对应的资源列表
     */
    private static final String XPATH_MOVIES_RESOURCE = "./ul/li";
    /**
     * 某一个资源种类下资源列表中的某资源名称
     */
    private static final String XPATH_MOVIES_RESOURCE_NAME = "./a/@title";
    /**
     * 某一个资源种类下资源列表中的某资源url
     */
    private static final String XPATH_MOVIES_RESOURCE_URL = "./span/a/@href";

    // xpath movie detail ---- end

    /**
     * BT电影天堂 base url
     */
    public static final String BASE_URL = "http://www.btbtdy.me";

    /**
     * 获取某关键字所有资源
     *
     * @param keyword
     * @param max     电影最大数
     * @return
     */
    public List<BtbtdyResource> getResource(String keyword, int max) {
        List<BtbtdyResource> btbtdyResources = new ArrayList<>();
        Map<String, String> movies = getMovieList(keyword, max);
        if (movies!=null) {
            for (String key : movies.keySet()) {
                BtbtdyResource btbtdyResource = getMovie(key, movies.get(key));
                if (btbtdyResource != null) {
                    btbtdyResources.add(btbtdyResource);
                }
            }
        }else {
            return null;
        }
        return btbtdyResources;
    }

    /**
     * 获取某电影相关资源
     *
     * @param name
     * @param url
     * @return
     */
    private BtbtdyResource getMovie(String name, String url) {
        // 返回类型
        BtbtdyResource btbtdyResource = new BtbtdyResource();
        btbtdyResource.setMovieName(name);
        Matcher matcher = URL_ID.matcher(url);
        if (matcher.find()) {
            int movieId = Integer.valueOf(matcher.group(0));
            btbtdyResource.setMovieId(movieId);
        }
        String html = null;
        try {
            Connection connect = Jsoup.connect(url);
            html = connect.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TagNode tagNode = new HtmlCleaner().clean(html);
        try {
            // 初始化 document xpath
            Document document = new DomSerializer(new CleanerProperties()).createDOM(tagNode);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // 分析Resource种类列表
            Object result = xPath.evaluate(XPATH_MOVIES_RESOURCE_LIST, document, XPathConstants.NODESET);
            if (result instanceof NodeList) {
                NodeList nodeListForMovieType = (NodeList) result;
                int resultSum = nodeListForMovieType.getLength();
                if (resultSum != 0) {
                    logger.info("(BT电影天堂)获取电影资源成功,共 " + resultSum + " 类...name: " + name);
                    for (int i = 0; i < resultSum; i++) {
                        Node node = nodeListForMovieType.item(i);
                        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            try {
                                // 分析resource某种类下 资源列表
                                Object ObjectForMovieList = xPath.evaluate(XPATH_MOVIES_RESOURCE, element, XPathConstants.NODESET);
                                if (ObjectForMovieList instanceof NodeList) {
                                    NodeList nodeListForMovieList = (NodeList) ObjectForMovieList;
                                    int movieListSum = nodeListForMovieList.getLength();
                                    // 当前资源类型名称
                                    String movieListTitle = (String) xPath.evaluate(XPATH_MOVIES_RESOURCE_TITLE, element, XPathConstants.STRING);
                                    if (movieListSum != 0) {
                                        logger.info("(BT电影天堂)获取电影资源某种类成功,共 " + movieListSum + " 个...name: " + name + "...种类: " + movieListTitle);
                                        // 当前种类下的资源列表
                                        List<Resource> resources = new ArrayList<>();
                                        for (int j = 0; j < movieListSum; j++) {
                                            Node nodeForMovie = nodeListForMovieList.item(j);
                                            if (nodeForMovie != null && nodeForMovie.getNodeType() == Node.ELEMENT_NODE) {
                                                Element elementForMovie = (Element) nodeForMovie;
                                                try {
                                                    // 分析 资源的 name url
                                                    Node nodeForName = (Node) xPath.evaluate(XPATH_MOVIES_RESOURCE_NAME, elementForMovie, XPathConstants.NODE);
                                                    Node nodeForUrl = (Node) xPath.evaluate(XPATH_MOVIES_RESOURCE_URL, elementForMovie, XPathConstants.NODE);
                                                    if (nodeForName != null && nodeForUrl != null) {
                                                        Resource resource = new Resource();
                                                        resource.setResourceName(nodeForName.getNodeValue());
                                                        resource.setResourceUrl(nodeForUrl.getNodeValue());
                                                        resources.add(resource);
                                                        logger.info("resource name: " + nodeForName.getNodeValue());
                                                        logger.info("resource url: " + nodeForUrl.getNodeValue());
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        // 分类存储
                                        switch (movieListTitle) {
                                            case BtbtdyResource.P720_TYPE:
                                                btbtdyResource.setP720(resources);
                                                break;
                                            case BtbtdyResource.P1080_TYPE:
                                                btbtdyResource.setP1080(resources);
                                                break;
                                            case BtbtdyResource.ED2K_TYPE:
                                                btbtdyResource.setEd2k(resources);
                                                break;
                                            case BtbtdyResource.K4_TYPE:
                                                btbtdyResource.setK4(resources);
                                                break;
                                            case BtbtdyResource.BLUE_TYPE:
                                                btbtdyResource.setBlue(resources);
                                                break;
                                            default:
                                                btbtdyResource.setUnknown(resources);
                                        }
                                    } else {
                                        logger.info("(BT电影天堂)获取电影资源某种类失败...name: " + name + "...种类: " + movieListTitle);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return btbtdyResource;
                } else {
                    logger.info("(BT电影天堂)获取电影资源失败...name: " + name);
                    return null;
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取电影搜索列表
     *
     * @param keyword
     * @param max     电影最大数
     * @return
     */
    private Map<String, String> getMovieList(String keyword, int max) {
        // 返回类型
        Map<String, String> movies = new LinkedHashMap();
        String url = BASE_URL + "/search/" + keyword + ".html";
        String html = null;
        try {
            Connection connect = Jsoup.connect(url);
            html = connect.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TagNode tagNode = new HtmlCleaner().clean(html);
        try {
            // 初始化 document xpath
            Document document = new DomSerializer(new CleanerProperties()).createDOM(tagNode);
            XPath xPath = XPathFactory.newInstance().newXPath();
            // 分析movie list
            Object resultForMovie = xPath.evaluate(XPATH_MOVIES, document, XPathConstants.NODESET);
            if (resultForMovie instanceof NodeList) {
                NodeList nodeListForMovie = (NodeList) resultForMovie;
                int movieSum = nodeListForMovie.getLength();
                if (movieSum != 0) {
                    logger.info("(BT电影天堂)获取电影搜索列表成功,共 " + movieSum + " 条...keyword: " + keyword);
                    for (int i = 0; i < movieSum && i < max; i++) {
                        Node node = nodeListForMovie.item(i);
                        if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            try {
                                Node nodeForName = (Node) xPath.evaluate(XPATH_MOVIE_NAME, element, XPathConstants.NODE);
                                Node nodeForUrl = (Node) xPath.evaluate(XPATH_MOVIE_URL, element, XPathConstants.NODE);
                                if (nodeForName != null && nodeForUrl != null) {
                                    String movieName = nodeForName.getNodeValue();
                                    String movieUrl = nodeForUrl.getNodeValue();
                                    Matcher matcher = URL_ID.matcher(movieUrl);
                                    if (matcher.find()) {
                                        int movieId = Integer.valueOf(matcher.group(0));
                                        String realUrl = BASE_URL + "/vidlist/" + movieId + ".html";
                                        movies.put(movieName, realUrl);
                                        logger.info("(BT电影天堂)获取电影...movie name: " + movieName);
                                        logger.info("(BT电影天堂)获取电影...movie url: " + movieUrl);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return movies;
                } else {
                    logger.info("(BT电影天堂)获取电影搜索列表失败...keyword: " + keyword);
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ResourceBtbtdy r = new ResourceBtbtdy();
        r.getResource("银河", 3);
    }
}
