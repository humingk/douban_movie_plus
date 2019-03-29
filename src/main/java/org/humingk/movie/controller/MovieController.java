package org.humingk.movie.controller;

import org.humingk.movie.config.JsonUtil;
import org.humingk.movie.entity.MovieAll;
import org.humingk.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/subject")
public class MovieController {

    @Autowired
    private MovieService movieService;


    /**
     * 根据url中的movieId 返回subject视图,并携带movieAll
     * @param movieId
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "{movieId}",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView subject(@PathVariable("movieId") int movieId, ModelAndView modelAndView){
        MovieAll movieAll = movieService.getMovieAllByMovieId(movieId);
        // 将对象转化为JSON字符串
        String movieAllString= JsonUtil.toJson(movieAll);
        modelAndView.addObject("movieAllString",movieAllString);
        modelAndView.setViewName("subject");
        return modelAndView;
    }
}
