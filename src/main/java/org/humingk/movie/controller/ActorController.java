package org.humingk.movie.controller;


import org.humingk.movie.common.CooperationActor;
import org.humingk.movie.common.Result;
import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.service.ActorService;
import org.humingk.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author humingk
 * @author J1anbo
 */
@Controller
@RequestMapping("/celebrity")
public class ActorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActorService actorService;
    @Autowired
    private MovieService movieService;

    /**
     * 根据url中的actorId 返回actor
     *
     * @param actorId
     * @return
     */
    @RequestMapping(value = "{actorId}", method = RequestMethod.GET)
    public Result actor(@PathVariable(value = "actorId") int actorId) {
        Actor actor;
        try {
            actor = actorService.getActorByActorId(actorId);
            // 成功获取演员，返回电影信息
            if (actor != null) {
                logger.debug("ID: " + actor.getActorId() + " Name: " + actor.getName() + " 有这个演员");
                return Result.createMessage(200, "success", actor);
            }
            //获取演员失败，返回添加演员确认信息
            else {
                logger.debug("ID: " + actorId + " 没有这个演员");
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return Result.createMessage(200, "fail", null);

    }

    /**
     * 根据演员id返回该演员参与的所有电影
     *
     * @param actorId
     * @return
     */
    @RequestMapping(value = "getAllMoviesByActorId", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllMoviesByActorId(@RequestParam("actorId") int actorId) {
        try {
            //获取主演电影列表
            List<Movie> movieList = movieService.getAllMoviesByActorId(actorId);
            return Result.createMessage(200, "success", movieList);
        } catch (Exception e) {
            logger.error("", e);
        }
        return Result.createMessage(200, "fail", null);
    }

    /**
     * 根据演员id返回与改演员合作的所有人员及电影
     *
     * @param actorId
     * @param cooperationMin     合作次数最小值
     * @return
     */
    @RequestMapping(value = "getCooperationActors", method = RequestMethod.GET)
    @ResponseBody
    public Result getCooperationActors(@RequestParam("actorId") int actorId, @RequestParam("cooperationMin") int cooperationMin) {
        try {
            //获取合作电影列表
            CooperationActor cooperationActor = actorService.getCoperationActor(actorId, cooperationMin);
            if (cooperationActor != null) {
                return Result.createMessage(200, "success", cooperationActor);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return Result.createMessage(200, "fail", null);
    }
}
