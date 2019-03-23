package org.humingk.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.humingk.movie.entity.MovieAll;
import org.humingk.movie.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView search(){
        return new ModelAndView("movieSearch","",new ArrayList<MovieAll>());
    }

    @RequestMapping(value = "searchResult",method = RequestMethod.POST)
    public String showSearch(@ModelAttribute("SpringWeb")ArrayList<MovieAll> movieAlls, ModelMap modelMap){
        for(MovieAll movieAll:movieAlls){
            modelMap.addAttribute("name",movieAll.getName());
            modelMap.addAttribute("alias",movieAll.getAlias());
            modelMap.addAttribute("releasetime",movieAll.getReleasetimes());
        }
        return "searchMovieAllResult";
    }
}
