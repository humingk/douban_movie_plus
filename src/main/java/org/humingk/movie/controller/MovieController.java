package org.humingk.movie.controller;

import org.humingk.movie.common.AddSession;
import org.humingk.movie.common.MovieAll;
import org.humingk.movie.common.ResultMessage;
import org.humingk.movie.service.MovieService;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = {"{movieId}","{movieId}/*"} , method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView subject(@PathVariable("movieId") int movieId, ModelAndView modelAndView) {
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
                logger.info("有这个电影");
                modelAndView.addObject("movieAllString", ResultMessage.createMessage(200, "OK", movieAll));
            }
            //获取电影失败，返回添加电影确认信息
            else {
                logger.info("没有这个电影");
                modelAndView.addObject("movieAllString", ResultMessage.createMessage(200, "ADD", null));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        modelAndView.setViewName("subject");
        return modelAndView;
    }

    /**
     * 添加数据库中没有的movieAll
     * @param movieAll
     * @return
     */
    @RequestMapping(value = "addMovieAll",method = RequestMethod.POST)
    @ResponseBody
    public String addMovieAll(@RequestBody MovieAll movieAll){
        // 添加成功
        if(movieService.addMovieAll(movieAll)){
            logger.info("从doubanAPI添加电影信息成功");
            // 将movieAll返回
        }
        // 添加失败
        else {
            logger.info("从doubanAPI添加电影信息失败");
        }
        return "";
    }

    /**
     * ===========此controller暂时没用==================
     *
     * 自动收录电影的跳转页
     * @param movieId
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "autoReflush",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView autoReflush(@RequestParam("movieId") int movieId,ModelAndView modelAndView){
        modelAndView.addObject("autoReflush",ResultMessage.createMessage(200,"OK",movieId));
        modelAndView.setViewName("autoReflush");
        return modelAndView;
    }

    /**
     * 更新数据库电影评分
     *
     * @param movieId
     * @param rate
     */
    @RequestMapping(value = "updateRate", method = RequestMethod.GET)
    public ModelAndView updateRate(@RequestParam("movieId") int movieId, @RequestParam("rate") float rate,
                                   ModelAndView modelAndView) {
        movieService.updateRateByMovieId(movieId, rate);
        modelAndView.addObject("success",ResultMessage.createMessage(200,"OK",null));
        modelAndView.setViewName("subject");
        return modelAndView;
    }
}
