package org.humingk.movie.controller;

import org.humingk.movie.entity.Movie;
import org.humingk.movie.entity.MovieAll;
import org.humingk.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService movieService;


    /**
     * 电影详细情况搜索，跳转到search页面
     * @param alias
     * @param model
     * @return
     */
//    @RequestMapping(value = "search", method = RequestMethod.POST)
//    public String showSearch(@RequestParam("alias") String alias, Model model) {
//        List<MovieAll> movieAlls = movieService.getMovieAllOfMovieByAlias(alias);
//        model.addAttribute("movieAlls",movieAlls);
//        return "search";
//    }


    /**
     * 电影基本情况搜索，ajax 搜索框智能提醒
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> searchTips(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Movie> movies = movieService.getMoviesByNameStart(name);
        return movies;
    }


    /**
     * 根据 movieID 返回电影详情页
     *
     * @return
     */
//    @RequestMapping(value = "subject/{movieId}",method = RequestMethod.GET)
//    @ResponseBody
//    public ModelAndView subject(@PathVariable(value = "movieId") int movieId){
//        MovieAll movieAll=movieService.getMovieAllByMovieId(movieId);
//        Map<String,MovieAll> data =new HashMap<String, MovieAll>();
//        data.put("movieAll",movieAll);
//        return new ModelAndView("subject/movie",data);
//    }


//    @RequestMapping(value = "subject/{movieId}",method = RequestMethod.GET)
//    public String subject(@PathVariable(value = "movieId") int movieId){
//        return "forward:/subject";
//    }
//
//    @RequestMapping(value = "subject/{movieId}",method = RequestMethod.GET)
//    @ResponseBody
//    public MovieAll subjectCreate(@PathVariable("movieId") int movieId){
//        MovieAll movieAll=movieService.getMovieAllByMovieId(movieId);
//        return movieAll;
//    }

    @RequestMapping(value = "subject/{movieId}", method = RequestMethod.GET)
    public String subject() {
        return "subject";
    }

    @RequestMapping(value = "subject/searchByUrl", method = RequestMethod.POST)
    @ResponseBody
    public MovieAll subjectCreate(@RequestParam("urlMovieId") int urlMovieId) {
        MovieAll movieAll = movieService.getMovieAllByMovieId(urlMovieId);
        return movieAll;
    }

}
