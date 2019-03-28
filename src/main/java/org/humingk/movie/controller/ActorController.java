package org.humingk.movie.controller;

import org.humingk.movie.config.JsonUtil;
import org.humingk.movie.entity.Actor;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author humin
 */
@Controller
@RequestMapping("/celebrity")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "{actorId}", method = RequestMethod.GET)
    public ModelAndView actor(@PathVariable(value = "actorId") int actorId, ModelAndView modelAndView) {
        Actor actor = actorService.getActor(actorId);
        modelAndView.addObject("actorString",JsonUtil.toJson(actor));

        List<Movie> moviesByDirector = actorService.getMoviesByDirectorId(actorId);
        modelAndView.addObject("moviesByDirectorString",JsonUtil.toJson(moviesByDirector));

        List<Movie> moviesByWriter= actorService.getMoviesByWriterId(actorId);
        modelAndView.addObject("moviesByWriterString",JsonUtil.toJson(moviesByWriter));

        List<Movie> moviesByleadingactor= actorService.getMoviesByleadingactorId(actorId);
        modelAndView.addObject("moviesByLeadingactorString",JsonUtil.toJson(moviesByleadingactor));

        modelAndView.setViewName("celebrity");
        return modelAndView;
    }
}
