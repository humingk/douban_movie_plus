package org.humingk.movie.common.resource;

import org.humingk.movie.common.resource.client.*;
import org.humingk.movie.common.resource.type.ClientType;
import org.humingk.movie.entity.Resource;
import org.humingk.movie.entity.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * 多线程获取电影资源信息
 *
 * @author humingk
 */
public class MovieResourceThread {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * client表
     */
    private Map<Integer, AbstractMovieResourceAdapter> clientMap;

    public MovieResourceThread() {
        clientMap = new LinkedHashMap<>();
        clientMap.put(ClientType.CLIENT_BTBTDY, new BtbtdyClient());
        clientMap.put(ClientType.CLIENT_DYGOD, new DygodClient());
        clientMap.put(ClientType.CLIENT_LOLDYTT, new LoldyttClient());
        clientMap.put(ClientType.CLIENT_XL720, new Xl720Client());
    }

    /**
     * 通过关键字多线程获取电影搜索结果
     *
     * @param keyword        搜索关键字
     * @param movieSearchMax 每个网站电影搜索结果最大数
     * @param threadMax      线程最大数
     * @return
     */
    public List<Search> getResourceSearch(
            String keyword, int movieSearchMax, int threadMax) {
        List<Search> result = null;
        try {
            ExecutorService service = newFixedThreadPool(threadMax);
            List<Future<List<Search>>> futureList = new ArrayList<>();
            // 多线程添加任务
            for (int clientType : clientMap.keySet()) {
                try {
                    Future<List<Search>> future = service.submit(() ->
                            clientMap.get(clientType).getMovieSearch(keyword, movieSearchMax)
                    );
                    futureList.add(future);
                } catch (Exception e) {
                    logger.error("多线程获取搜索结果，某网站失败,clientType: " + clientType, e);
                }
            }
            // 多线程返回结果
            result = new ArrayList<>();
            for (Future<List<Search>> future : futureList) {
                if (future.get() != null) {
                    result.addAll(future.get());
                }
            }
            service.shutdown();
            logger.debug("多线程获取搜索结果成功,keyword:" + keyword + " size:" + result.size());
        } catch (Exception e) {
            logger.error("多线程获取搜索结果失败,keyword:" + keyword, e);
        }
        return result;
    }

    /**
     * 通过电影表列表多线程获取电影资源信息
     *
     * @param threadMax  线程最大数
     * @param searchList 电影表列表
     * @return
     */
    public List<Resource> getResourceAll(
            int threadMax, List<Search> searchList) {
        List<Resource> result = null;
        String keyword = null;
        try {
            ExecutorService service = newFixedThreadPool(threadMax);
            List<Future<List<Resource>>> futureList = new ArrayList<>();
            // 多线程添加任务
            for (Search search : searchList) {
                try {

                    Future<List<Resource>> future = service.submit(() ->
                            clientMap.get(search.getClientType()).getMovieResource(search)
                    );
                    futureList.add(future);
                } catch (Exception e) {
                    logger.error("多线程获取电影资源，某电影页面失败,keyword: " + search.getKeyword()
                            + " movieUrl: " + search.getMovieUrl(), e);
                }
            }
            // 多线程返回结果
            result = new ArrayList<>();
            for (Future<List<Resource>> future : futureList) {
                if (future.get() != null) {
                    result.addAll(future.get());
                    keyword = future.get().get(0).getKeyword();
                }
            }
            service.shutdown();
            logger.debug("多线程获取电影资源成功,keyword:" + keyword + " size:" + result.size());
        } catch (Exception e) {
            logger.error("多线程获取电影资源失败,keyword:" + keyword);
        }
        return result;
    }
}
