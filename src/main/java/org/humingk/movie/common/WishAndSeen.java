package org.humingk.movie.common;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WishAndSeen {
    /**
     * 解析url中的 ID
     */
    private static final Pattern URLID = Pattern.compile("(\\d+)");

    /**
     * movieSum XPATH
     */
    private static final String XPATH_TITLE = "//h1/text()";

    /**
     * movie            XPATH
     */
    private static final String XPATH_MOVIE = "//ul[@class='list-view']/li";

    /**
     * movie    id      XPATH
     */
    private static final String XPATH_ID = "./@id";

    /**
     * movie    rate    XPATH
     */
    private static final String XPATH_RATE = ".//div[@class='date']/span/@class";

    /**
     * 存储所有的movieID
     */
    private HashMap<Integer, Integer> movies;

    /**
     * 电影总数
     */
    private int movieSum = -1;

    /**
     * 每一页的电影总数
     */
    private static final int PAGE_NUM = 30;

    public WishAndSeen() {
        movies = new HashMap<>();
        movieSum = -1;
    }

    public int getMovieSum() {
        return movieSum;
    }

    /**
     * 根据 label，获取所有的电影ID
     *
     * @param label
     * @return
     */
    public HashMap<Integer, Integer> getAllMovie(String label, String type) {
        String url = "https://movie.douban.com/people/" + label + "/" + type + "?sort=time&rating=all&filter=all&mode=list&start=";
        if (movieSum == -1) {
            boolean isOk = getPageMovie(url + "0");
            if (!isOk) {
                return movies;
            }
        }
        for (int i = PAGE_NUM; i <= movieSum; i += PAGE_NUM) {
            try {
                System.out.println("---------------------------");
                System.out.println("第" + i / PAGE_NUM + "页");

                boolean isOk = getPageMovie(url + i);
                if (!isOk) {
                    return movies;
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

    /**
     * 根据 每一页的url 获取每一页的电影ID
     *
     * @param url
     * @return 是否爬取到ID
     */
    public boolean getPageMovie(String url) {
        // 标记是否成功
        boolean re = true;
        // 开始爬取网页
        String html;
        try {
            Connection connect = Jsoup.connect(url);
            html = connect.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        TagNode tagNode = new HtmlCleaner().clean(html);

        try {
            // 初始化 document xpath
            Document document = new DomSerializer(new CleanerProperties()).createDOM(tagNode);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // 获取 movie总数
            if (movieSum == -1) {
                String title = (String) xPath.evaluate(XPATH_TITLE, document, XPathConstants.STRING);
                Matcher matcher = URLID.matcher(title);
                if (matcher.find()) {
                    movieSum = Integer.valueOf(matcher.group(0));
                }
            }

            // 解析 movie
            Object resultForMovie = xPath.evaluate(XPATH_MOVIE, document, XPathConstants.NODESET);
            if (resultForMovie instanceof NodeList) {
                NodeList nodeListForMovie = (NodeList) resultForMovie;
                for (int i = 0; i < nodeListForMovie.getLength(); i++) {
                    int movieId=0;
                    int rate=0;
                    Node node = nodeListForMovie.item(i);
                    if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;

                        // 解析movieId
                        try {
                            Node nodeForId = (Node) xPath.evaluate(XPATH_ID, element, XPathConstants.NODE);
                            Matcher matcherForId = URLID.matcher(nodeForId.getNodeValue());
                            if (matcherForId.find()) {
                                movieId=Integer.valueOf(matcherForId.group(0));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // 解析 rate
                        try {
                            Node nodeForRate = (Node) xPath.evaluate(XPATH_RATE, element, XPathConstants.NODE);
                            if(nodeForRate!=null){
                                Matcher matcherForRate = URLID.matcher(nodeForRate.getNodeValue());
                                if (matcherForRate.find()) {
                                    System.out.println(Integer.valueOf(matcherForRate.group(0)));
                                    rate=Integer.valueOf(matcherForRate.group(0));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    movies.put(movieId,rate);
                    System.out.println("----------------");
                    System.out.println(movieId+" - "+rate);
                }
            } else {
                re = false;
            }
        } catch (
                Exception e) {
            e.printStackTrace();
            return false;
        }
        return re;
    }

    public static void main(String[] args) {
        WishAndSeen t = new WishAndSeen();
        HashMap<Integer, Integer> t1 = t.getAllMovie("humingk", "wish");
        System.out.println("想看总数: " + t.getMovieSum());
        System.out.println("爬取到: " + t1.size());
        for(Integer key:t1.keySet()){
            System.out.print(key+"-"+t1.get(key)+" ");
        }
        System.out.println();
        System.out.println("==================================================");

        WishAndSeen tt = new WishAndSeen();
        HashMap<Integer, Integer> t2 = tt.getAllMovie("humingk", "collect");
        System.out.println("看过总数: " + tt.getMovieSum());
        System.out.println("爬取到: " + t2.size());
        for(Integer key:t2.keySet()){
            System.out.print(key+"-"+t2.get(key)+" ");
        }
    }
}
