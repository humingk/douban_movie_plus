package org.humingk.movie.common.resource;

import org.humingk.movie.common.resource.client.BtbtdyClient;
import org.humingk.movie.common.resource.client.DygodClient;
import org.humingk.movie.common.resource.client.LoldyttClient;
import org.humingk.movie.common.resource.client.Xl720Client;
import org.humingk.movie.common.resource.pojo.Movie;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * 多线程获取电影资源信息
 *
 * @author humingk
 */
public class MovieResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    /**
//     * 搜索关键字
//     */
//    private String keyword;
//    /**
//     * 电影表最大数
//     */
//    private int movieMapMax;
//    /**
//     * 线程最大数
//     */
//    private int threadMax;
//    /**
//     * client列表
//     */
//    private List<AbstractMovieResourceAdapter> clients = Arrays.asList(
//            new BtbtdyClient(), new LoldyttClient(), new DygodClient(), new Xl720Client()
//    );

    public MovieResource() {
    }

    public MovieResource(String keyword, int movieMapMax, int threadMax) {
        this.keyword = keyword;
        this.movieMapMax = movieMapMax;
        this.threadMax = threadMax;
    }

    /**
     * 通过关键字多线程获取电影表列表
     *
     * @param keyword
     * @param movieMapMax
     * @param threadMax
     * @param clients
     * @return
     */
    public List<MovieMap> getMovieResourceByKeyword(
            String keyword, int movieMapMax, int threadMax, List<AbstractMovieResourceAdapter> clients) {
        List<MovieMap> result = null;
        try {
            // 多线程
            ExecutorService service = newFixedThreadPool(threadMax);
            List<Future<MovieMap>> futureList = new ArrayList<>();
            for (AbstractMovieResourceAdapter client : clients) {
                Future<MovieMap> future = service.submit(() ->
                        client.getMovieMap(keyword, movieMapMax)
                );
                futureList.add(future);
            }
            for (Future<MovieMap> future : futureList) {
                result.add(future.get());
                System.out.println(future.get().getClientType());
                for (Movie movie : future.get().getMovies()) {
                    System.out.println(movie.getMovieName() + " " + movie.getMovieUrl());
                }
            }
            service.shutdown();
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 通过电影表获取电影资源信息
     *
     * @param movieMap
     * @param threadMax
     * @return
     */
    public <T> T getMovieResourceByMovieMap(MovieMap movieMap,int threadMax) {
        List<T> result = null;
        try {
            // 多线程
            ExecutorService service = newFixedThreadPool(threadMax);
            List<Future<T>> futureList = new ArrayList<>();
            for (AbstractMovieResourceAdapter client : clients) {
                Future<T> future = service.submit(() ->
                        client.getMovie(movieMap.getMovies())
                );
                futureList.add(future);
            }
            for (Future<MovieMap> future : futureList) {
                result.add(future.get());
                System.out.println(future.get().getClientType());
                for (String key : future.get().getMovies().keySet()) {
                    System.out.println(key + " " + future.get().getMovies().get(key));
                }
            }
            service.shutdown();
        } catch (Exception e) {
            logger.error("", e);
        }
        return result;


        // 获取电影搜索列表
        Map<String, String> movies = getMovieMap(keyword, max);
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
        return null;
    }

}
