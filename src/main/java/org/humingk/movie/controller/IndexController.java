package org.humingk.movie.controller;

import org.humingk.movie.common.MovieAll;
import org.humingk.movie.common.Result;
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

import java.util.List;

/**
 * @author humingk
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private MovieService movieService;


    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        if (movies.size() != 0) {
            logger.info(keyword + " 返回此关键字的电影简称");
            return Result.createMessage(200, "success", movies);
        } else {
            logger.info(keyword + " 没有此关键字的电影简称");
            return Result.createMessage(200, "fail", null);
        }
    }

    /**
     * 搜索页面
     * 用于 无限加载 懒加载
     *
     * @param keyword
     * @param start
     * @param count
     * @return
     */
    @RequestMapping(value = "subject_search", method = RequestMethod.GET)
    @ResponseBody
    public Result search(@RequestParam("search_text") String keyword,@RequestParam("start") int start,@RequestParam("count")int count) {
        try {
            List<MovieAll> movieAlls = movieService.getMovieAllsOfMovieByAlias(keyword,start,count);
            if (movieAlls.size() > 0) {
                logger.info(keyword+" 返回此关键字电影 第 "+start+" 条,共 "+count+" 条，累计 "+movieAlls.size()+" 条");
                return Result.createMessage(200, "success", movieAlls);
            } else {
                logger.info(keyword+" 无此关键字电影 ");
                return Result.createMessage(200, "fail", null);
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return Result.createMessage(200, "fail", null);
        }
    }
}