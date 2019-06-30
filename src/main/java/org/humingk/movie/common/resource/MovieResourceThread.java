package org.humingk.movie.common.resource;

import org.humingk.movie.common.resource.client.BtbtdyClient;
import org.humingk.movie.common.resource.client.DygodClient;
import org.humingk.movie.common.resource.client.LoldyttClient;
import org.humingk.movie.common.resource.client.Xl720Client;
import org.humingk.movie.common.resource.pojo.ClientResource;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieAllResource;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
     * client列表
     */
    List<AbstractMovieResourceAdapter> clients = Arrays.asList(
            new BtbtdyClient(), new DygodClient(), new LoldyttClient(), new Xl720Client()
    );

    /**
     * 泛型对象实例化
     *
     * @param c
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static <T> T newTclass(Class<T> c) throws InstantiationException, IllegalAccessException {
        T t = c.newInstance();
        return t;
    }

    /**
     * 通过关键字多线程获取电影表列表
     *
     * @param keyword     搜索关键字
     * @param movieMapMax 电影了列表中表中电影个数限制
     * @param threadMax   线程最大数
     * @return
     */
    public List<MovieMap<? extends AbstractMovieResourceAdapter>> getMovieMapListByKeyword(
            String keyword, int movieMapMax, int threadMax) {
        List<MovieMap<? extends AbstractMovieResourceAdapter>> result = null;
        try {
            ExecutorService service = newFixedThreadPool(threadMax);
            List<Future<MovieMap<? extends AbstractMovieResourceAdapter>>> futureList = new ArrayList<>();
            // 多线程添加任务
            for (AbstractMovieResourceAdapter client : clients) {
                Future<MovieMap<? extends AbstractMovieResourceAdapter>> future = service.submit(() ->
                        client.getMovieMap(keyword, movieMapMax)
                );
                futureList.add(future);
            }
            // 多线程返回结果
            result = new ArrayList<>();
            for (Future<MovieMap<? extends AbstractMovieResourceAdapter>> future : futureList) {
                if (future.get() != null) {
                    result.add(future.get());
                    // 测试
                    System.out.println(future.get().getClientType());
                    for (Movie movie : future.get().getMovies()) {
                        System.out.println(movie.getMovieName() + " " + movie.getMovieUrl());
                    }
                }
            }
            service.shutdown();
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 通过电影表列表多线程获取电影资源信息
     *
     * @param threadMax    线程最大数
     * @param movieMapList 电影表列表
     * @return
     */
    public MovieAllResource getMovieResourceByMovieMapList(
            int threadMax, List<MovieMap<? extends AbstractMovieResourceAdapter>> movieMapList) {
        MovieAllResource result = null;
        String keyword = null;
        List<ClientResource<? extends ClientResource>> resourceList = null;
        try {
            ExecutorService service = newFixedThreadPool(threadMax);
            List<Future<ClientResource<? extends ClientResource>>> futureList = new ArrayList<>();
            // 多线程添加任务
            for (MovieMap<? extends AbstractMovieResourceAdapter> movieMap : movieMapList) {
                for (Movie movie : movieMap.getMovies()) {
                    Future<ClientResource<? extends ClientResource>> future = service.submit(() ->
                            newTclass(movieMap.getClientType()).getMovie(movie)
                    );
                    futureList.add(future);
                }
            }
            // 多线程返回结果
            result = new MovieAllResource();
            resourceList = new ArrayList<>();
            for (Future<ClientResource<? extends ClientResource>> future : futureList) {
                if (future.get() != null) {
                    resourceList.add(future.get());
                }
            }
            result.setMovieMapList(movieMapList);
            result.setResourceList(resourceList);
            service.shutdown();
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }
}
