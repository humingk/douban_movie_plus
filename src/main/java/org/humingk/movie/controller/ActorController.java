package org.humingk.movie.controller;

import org.humingk.movie.entity.Actor;
import org.humingk.movie.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author humin
 */
@Controller
@RequestMapping("/")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "celebrity/{actorId}", method = RequestMethod.GET)
    public String actor(@PathVariable(value = "actorId") int actorId, ModelMap modelMap) {
        Actor actor = actorService.getActor(actorId);
        modelMap.addAttribute("actor", actor);
        return "celebrity";
    }

}
