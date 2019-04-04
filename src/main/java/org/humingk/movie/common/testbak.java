package org.humingk.movie.common;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testbak {
    /**
     * 解析url中的 ID
     */
    private static final Pattern URLID = Pattern.compile("(\\d+)");

    /**
     * 存储所有的movieID
     */
    private List<Integer> movieIds;

    /**
     * 电影总数
     */
    private int movieSum = -1;

    /**
     * 每一页的电影总数
     */
    private static final int PAGE_NUM = 30;

    public testbak() {
        movieIds = new ArrayList<>();
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
    public List<Integer> getAllMovie(String label, String type) {
        String url = "https://movie.douban.com/people/" + label + "/" + type + "?sort=time&rating=all&filter=all&mode=list&start=";
        if (movieSum == -1) {
            boolean isOk = getPageMovie(url + "0");
            if (!isOk) {
                return movieIds;
            }
        }
        for (int i = PAGE_NUM; i <= movieSum; i += PAGE_NUM) {
            try {
                System.out.println("--------");
                System.out.println("第" + i / PAGE_NUM + "页");

                boolean isOk = getPageMovie(url + i);
                if (!isOk) {
                    return movieIds;
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return movieIds;
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
                String title = (String) xPath.evaluate("//h1/text()", document, XPathConstants.STRING);
                Matcher matcher = URLID.matcher(title);
                if (matcher.find()) {
                    movieSum = Integer.valueOf(matcher.group(0));
                }
            }

            // 解析 movieId
            Object resultForId = xPath.evaluate("//div[@class='title']//@href", document, XPathConstants.NODESET);
            if (resultForId instanceof NodeList) {
                NodeList nodeList = (NodeList) resultForId;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    Matcher matcher = URLID.matcher(node.getNodeValue());
                    if (matcher.find()) {
                        movieIds.add(Integer.valueOf(matcher.group(0)));
                    } else {
                        re = false;
                    }
                }
            } else {
                re = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return re;
    }

    public static void main(String[] args) {
        testbak t = new testbak();
        List<Integer> t1 = t.getAllMovie("humingk", "wish");
        System.out.println("想看总数: " + t.getMovieSum());
        System.out.println("爬取到: " + t1.size());
        for (int i = 0; i < t1.size(); i++) {
            System.out.print(t1.get(i) + " ");
        }
        System.out.println();
        System.out.println("==================================================");

        testbak tt = new testbak();
        List<Integer> t2 = tt.getAllMovie("humingk", "collect");
        System.out.println("看过总数: " + tt.getMovieSum());
        System.out.println("爬取到: " + t2.size());
        for (int i = 0; i < t2.size(); i++) {
            System.out.print(t2.get(i) + " ");
        }
    }
}
