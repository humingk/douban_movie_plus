package org.humingk.movie.controller;

import org.humingk.movie.common.AddSession;
import org.humingk.movie.common.MovieAll;
import org.humingk.movie.common.Result;
import org.humingk.movie.service.MovieService;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author humin
 */
@Controller
@RequestMapping("/subject")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 根据url中的movieId 返回subject视图,并携带movieAll
     *
     * @param movieId
     * @return
     */
    @RequestMapping(value = {"{movieId}","{movieId}/*"} , method = RequestMethod.GET)
    @ResponseBody
    public Result subject(@PathVariable("movieId") int movieId) {
        MovieAll movieAll;
        try{
            // 给用户添加session
            if(AddSession.add(userService)){
                logger.info("添加session成功");
            }else {
                logger.info("添加session失败");
            }
            movieAll = movieService.getMovieAllByMovieId(movieId);
            // 成功获取电影，返回电影信息
            if(movieAll!=null){
                logger.info("ID: "+movieAll.getMovieId()+" Name: "+movieAll.getName()+" 有这个电影");
                return Result.createMessage(200,"success",movieAll);
            }
            //获取电影失败，返回添加电影确认信息
            else {
                logger.info("ID: "+movieId+" 没有这个电影");
                return Result.createMessage(200,"fail",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加数据库中没有的movieAll
     * @param movieAll
     * @return
     */
    @RequestMapping(value = "addMovieAll",method = RequestMethod.POST)
    @ResponseBody
    public Result addMovieAll(@RequestBody MovieAll movieAll){
        // 添加成功
        if(movieService.addMovieAll(movieAll)){
            logger.info("从doubanAPI添加电影信息成功");
            return Result.createMessage(200,"success",null);
            // 将movieAll返回
        }
        // 添加失败
        else {
            logger.info("从doubanAPI添加电影信息失败");
            return Result.createMessage(200,"fail",null);
        }
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
        if(movieService.updateRateByMovieId(movieId, rate)){
            logger.info("更新rate成功...");
            return Result.createMessage(200,"success",null);
        }else {
            logger.info("更新rate成功...");
            return Result.createMessage(200,"fail",null);
        }
    }
}
