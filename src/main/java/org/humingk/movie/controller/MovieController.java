package org.humingk.movie.controller;

import org.humingk.movie.common.*;
import org.humingk.movie.service.MovieService;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author humingk
 */
@Controller
@RequestMapping("/subject")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据url中的movieId 返回subject视图,并携带movieAll
     *
     * @param movieId
     * @return
     */
    @RequestMapping(value = {"{movieId}", "{movieId}/*"}, method = RequestMethod.GET)
    @ResponseBody
    public Result subject(@PathVariable("movieId") int movieId) {
        MovieAll movieAll;
        try {
            // 给用户添加session
            if (AddSession.add(userService)) {
                logger.info("添加session成功");
            } else {
                logger.info("添加session失败");
            }
            movieAll = movieService.getMovieAllByMovieId(movieId);
            // 成功获取电影，返回电影信息
            if (movieAll != null) {
                logger.info("ID: " + movieAll.getMovieId() + " Name: " + movieAll.getName() + " 有这个电影");
                return Result.createMessage(200, "success", movieAll);
            }
            //获取电影失败，返回添加电影确认信息
            else {
                logger.info("ID: " + movieId + " 没有这个电影");
                return Result.createMessage(200, "fail", null);
            }
        } catch (Exception e) {
            logger.error("",e);
            return null;
        }
    }

    /**
     * 添加数据库中没有的movieAll
     *
     * @param movieAll
     * @return
     */
    @RequestMapping(value = "addMovieAll", method = RequestMethod.POST)
    @ResponseBody
    public Result addMovieAll(@RequestBody MovieAll movieAll) {
        // 添加成功
        if (movieService.addMovieAll(movieAll)) {
            logger.info("从doubanAPI添加电影信息成功");
            return Result.createMessage(200, "success", null);
            // 将movieAll返回
        }
        // 添加失败
        else {
            logger.info("从doubanAPI添加电影信息失败");
            return Result.createMessage(200, "fail", null);
        }
    }

    /**
     * 获取Btbtdy资源信息
     *
     * @param keyword
     * @return
     */
    @RequestMapping(value = "getBtbtdyResource", method = RequestMethod.GET)
    @ResponseBody
    public Result getBtbtdyResource(@RequestParam("keyword") String keyword) {
        try {
            ResourceBtbtdy resourceBtbtdy = new ResourceBtbtdy();
            List<BtbtdyResource> btbtdyResources = resourceBtbtdy.getResource(keyword, 1);
            if (btbtdyResources != null && btbtdyResources.size() != 0) {
                logger.info("(BT电影天堂)获取电影资源信息成功,共计 " + btbtdyResources.size() + " 个电影...keyword: " + keyword);
                return Result.createMessage(200, "success", btbtdyResources);
            } else {
                logger.info("(BT电影天堂)获取电影资源信息失败...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        return Result.createMessage(200, "fail", null);
    }

    /**
     * 获取 Loldytt 电影资源信息
     *
     * @param keyword
     * @return
     */
    @RequestMapping(value = "getLoldyttResource", method = RequestMethod.GET)
    @ResponseBody
    public Result getLoldyttResource(@RequestParam("keyword") String keyword) {
        try {
            ResourceLoldytt resourceLoldytt = new ResourceLoldytt();
            List<LoldyttResource> loldyttResources = resourceLoldytt.getResource(keyword, 1);
            if (loldyttResources != null && loldyttResources.size() != 0) {
                logger.info("(LOL电影天堂)获取电影资源信息成功,共计 " + loldyttResources.size() + " 个电影...keyword: " + keyword);
                return Result.createMessage(200, "success", loldyttResources);
            }else {
                logger.info("(LOL电影天堂)获取电影资源信息失败...keyword: " + keyword);
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        return Result.createMessage(200, "fail", null);
    }

    /**
     * 更新数据库电影评分
     *
     * @param movieId
     * @param rate
     */
    @RequestMapping(value = "updateRate", method = RequestMethod.GET)
    @ResponseBody
    public Result updateRate(@RequestParam("movieId") int movieId, @RequestParam("rate") float rate) {
        if (movieService.updateRateByMovieId(movieId, rate)) {
            logger.info("更新rate成功...movieId: " + movieId);
            return Result.createMessage(200, "success", null);
        } else {
            logger.info("更新rate失败...movieId: " + movieId);
            return Result.createMessage(200, "fail", null);
        }
    }

    /**
     * 更新 imdbId
     *
     * @param movieId
     * @param imdbId
     * @return
     */
    @RequestMapping(value = "updateImdbId", method = RequestMethod.GET)
    @ResponseBody
    public Result updateImdbid(@RequestParam("movieId") int movieId, @RequestParam("imdbId") String imdbId) {

        if (movieService.updateImdbIdByMovieId(movieId, imdbId)) {
            logger.info("更新imdbId成功...movieId: " + movieId);
            return Result.createMessage(200, "success", null);
        } else {
            logger.info("更新imdbId失败...movieid: " + movieId);
            return Result.createMessage(200, "fail", null);
        }
    }

}
