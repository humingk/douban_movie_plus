package org.humingk.movie.controller;

import org.humingk.movie.common.MovieAll;
import org.humingk.movie.common.ResultMessage;
import org.humingk.movie.service.MovieService;
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


    /**
     * 根据url中的movieId 返回subject视图,并携带movieAll
     *
     * @param movieId
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView subject(@PathVariable("movieId") int movieId, ModelAndView modelAndView) {
        MovieAll movieAll= new MovieAll();
        try{
            // 成功获取电影，返回电影信息
            movieAll = movieService.getMovieAllByMovieId(movieId);
            modelAndView.addObject("movieAllString", ResultMessage.createMessage(200, "OK", movieAll));
        }catch (Exception e){
            //获取电影失败，返回添加电影确认信息
            modelAndView.addObject("movieAllString", ResultMessage.createMessage(200, "ADD", null));
        }
        modelAndView.setViewName("subject");
        return modelAndView;
    }

    /**
     * 添加数据库中没有的movieAll
     * @param movieAll
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "addMovieAll",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView addMovieAll(@RequestBody MovieAll movieAll,ModelAndView modelAndView){
        if(movieService.addMovieAll(movieAll)){
            modelAndView.addObject("isAdded",ResultMessage.createMessage(200,"OK",null));
        }else {
            modelAndView.addObject("isAdded",ResultMessage.createMessage(200,"NO",null));
        }
        modelAndView.setViewName("subject");
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
