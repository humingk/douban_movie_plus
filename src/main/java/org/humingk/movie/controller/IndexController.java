package org.humingk.movie.controller;

import org.humingk.movie.common.MovieAll;
import org.humingk.movie.common.Result;
import org.humingk.movie.common.ResultMessage;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.service.MovieService;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author humin
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private MovieService movieService;


    @Autowired
    private UserService userService;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

//    @RequestMapping(value = "index",method = RequestMethod.GET)
//    @ResponseBody
//    private User index(){
//        Subject currentUser= SecurityUtils.getSubject();
//        Session  session=currentUser.getSession();
//        session.setAttribute("currentUser",);
//        User userInfo=null;
//        // 表示用户是记住我登录的
//        if(subject.isRemembered()){
//            String userEmail=currentUs
//            userInfo =userService.getUserInfoByUserLabel(subject.);
//        }
//        return userInfo;
//    }


    /**
     * 首页搜索框智能提醒
     *
     * @param keyword
     * @return
     */
    @RequestMapping(value = "searchTips", method = RequestMethod.GET)
    @ResponseBody
    public Result searchTips(@RequestParam("keyword") String keyword) {
        List<Movie> movies = movieService.getMoviesByNameStart(keyword);
        return Result.createMessage(200,"success",movies);
    }

    @RequestMapping(value = "search",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView search(@RequestParam("keyword") String keyword, ModelAndView modelAndView){
        List<MovieAll> movieAlls=movieService.getMovieAllsOfMovieByAlias(keyword);
        modelAndView.addObject("movieAllsString", ResultMessage.createMessage(200,"OK",movieAlls));
        modelAndView.setViewName("search");
        return modelAndView;
    }
}
