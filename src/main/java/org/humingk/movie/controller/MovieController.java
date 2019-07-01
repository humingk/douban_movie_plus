package org.humingk.movie.controller;

import org.humingk.movie.common.AddSession;
import org.humingk.movie.common.MovieAll;
import org.humingk.movie.common.Result;
import org.humingk.movie.common.resource.AbstractMovieResourceAdapter;
import org.humingk.movie.common.resource.pojo.MovieAllResource;
import org.humingk.movie.common.resource.pojo.MovieMap;
import org.humingk.movie.service.MovieService;
import org.humingk.movie.service.ResourceService;
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
    @Autowired
    private ResourceService resourceService;

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
            logger.error("", e);
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
     * 通过关键字获取电影资源:电影表列表/电影资源
     *
     * @param keyword     搜索关键字
     * @param requestType 请求类型
     *                    0 电影表列表
     *                    1 电影资源
     * @param dateType    电影上映时间类型
     *                    0 新电影始终请求电影表列表和电影资源---搜索后列表搜索标记记为未搜索，资源搜索标志记为未搜索
     *                    1 未知时间电影有选择请求电影表列表，始终请求电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为未搜索
     *                    2 老电影有选择请求电影列表列表和电影资源---搜索后列表搜索标记记为已搜索，资源搜索标记记为已搜索
     * @return
     */
    @RequestMapping(value = "getResource", method = RequestMethod.GET)
    @ResponseBody
    public Result getResource(
            @RequestParam("keyword") String keyword,
            @RequestParam("requestType") int requestType,
            @RequestParam("dateType") int dateType) {
        try {
            // 请求电影表列表
            if (requestType == 0) {
                List<MovieMap<? extends AbstractMovieResourceAdapter>> movieMapList =
                        resourceService.getResourceMapList(keyword, dateType, 3, 5);
                if (movieMapList != null) {
                    return Result.createMessage(200, "success", movieMapList);
                }
            }
            // 请求电影资源
            else if (requestType == 1) {
                MovieAllResource movieAllResource = resourceService.getMovieAllResource(keyword, dateType, 10);
                if (movieAllResource != null) {
                    return Result.createMessage(200, "success", movieAllResource);
                }
            }
        } catch (Exception e) {
            logger.error("", e);
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
