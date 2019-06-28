package org.humingk.movie.controller;


import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.service.ActorService;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.humingk.movie.common.*;

import java.util.List;

/**
 * @author humin
 * @author J1anbo
 * @see humingk
 */
@Controller
@RequestMapping("/celebrity")
public class ActorController {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActorService actorService;
    @Autowired
    private UserService userService;

    /**
     * 根据url中的actorId 返回Result,并携带actor
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
                    logger.info("ID: " + actor.getActorId() + " Name: " + actor.getName() + " 有这个演员");
                return Result.createMessage(200, "success", actor);
            }
            //获取演员失败，返回添加演员确认信息
            else {
                logger.info("ID: " + actorId + " 没有这个演员");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.createMessage(200, "fail", null);

    }

    /**
     * 根据演员id返回该演员参与的所有电影
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getAllMoviesByActorId", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllMoviesByActorId(@RequestParam("id") String id){
        try{
            //获取主演电影列表
            List<List<Movie>> movies = actorService.getAllMoviesByActorId(Integer.parseInt(id));
            return Result.createMessage(200,"success",movies);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.createMessage(200,"fail",null);
    }

    /**
     * 根据演员id返回与改演员合作的所有人员及电影
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getCoomovieByActorId", method = RequestMethod.GET)
    @ResponseBody
    public Result getCoomovieByActorId(@RequestParam("id") String id){
        try{
            //获取合作电影列表
            List<CooperationActor> coomovieList = actorService.getCoomovieByActorId(Integer.parseInt(id));
            return Result.createMessage(200,"success",coomovieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.createMessage(200,"fail",null);
    }
}
