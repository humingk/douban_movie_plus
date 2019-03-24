package org.humingk.movie.controller;

import org.humingk.movie.entity.MovieAll;
import org.humingk.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/")
public class MovieController {

    @Autowired
    private MovieService movieService;

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public ModelAndView search()throws Exception{
//        List<MovieAll> movieAlls=movieService.getMovieAllOfMovieByAlias("");
//
//        return new ModelAndView("movieSearch","",new ArrayList<MovieAll>());
//    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView movie(){
        return new ModelAndView("index","command",new MovieAll());
    }


    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String search(@ModelAttribute("SpringWeb") String alias, ModelMap modelMap) throws Exception{
        List<MovieAll> movieAlls=movieService.getMovieAllOfMovieByAlias(alias);
        modelMap.addAttribute("name",movieAlls.get(0).getName());
        modelMap.addAttribute("name",movieAlls.get(0).getAlias());
        modelMap.addAttribute("name",movieAlls.get(0).getReleasetimes().get(0));
        return "result";
    }
}
