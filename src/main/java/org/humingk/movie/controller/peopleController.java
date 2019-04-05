package org.humingk.movie.controller;

import org.humingk.movie.common.WishAndSeen;
import org.humingk.movie.entity.UserMovie;
import org.humingk.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author humin
 */
@RequestMapping(value = "/people")
@Controller
public class peopleController {

    @Autowired
    private UserService userService;

    private static final String WISH = "wish";
    private static final String SEEN = "seen";
    private static final String COLLECT= "collect";

    /**
     * 响应url路径 people/{userId} or people/{label}
     *
     * @param modelAndView
     * @param labelOrId
     * @return
     */
    @RequestMapping(value = "{labelOrId}")
    public ModelAndView people(ModelAndView modelAndView, @PathVariable String labelOrId) {
        String pattern = "\\d+";
        // labelOrId 是ID
        if (Pattern.matches(pattern, labelOrId)) {

        }
        // labelOrId 是label
        else {

        }
        modelAndView.setViewName("/people");
        return modelAndView;
    }

    /**
     * 获取wishsAndseens
     *
     * @param label
     * @return
     */
    @RequestMapping(value = "getWishsAndSeens", method = RequestMethod.GET)
    @ResponseBody
    public List<UserMovie> getWish(@RequestParam("label") String label) {
        return userService.getWishsAndSeensByUserLabel(label);
    }

    /**
     * 手动更新washsAndSeens
     *
     * @param label
     * @return
     */
    @RequestMapping(value = "updateWishsAndSeens", method = RequestMethod.GET)
    public String updateWishsAndSeens(@RequestParam("label") String label) {
        try {
            WishAndSeen wishUtil = new WishAndSeen();
            HashMap<Integer, Integer> wishs = wishUtil.getAllMovie(label, WISH);
            if (userService.updateWishAndSeen(wishs, label, WISH)) {
                System.out.println("更新wishs成功============");
            } else {
                System.out.println("更新wishs失败============");
            }
            WishAndSeen seenUtil = new WishAndSeen();
            HashMap<Integer, Integer> seens = seenUtil.getAllMovie(label, COLLECT);
            if (userService.updateWishAndSeen(seens, label, SEEN)) {
                System.out.println("更新seens成功============");
            } else {
                System.out.println("更新seens失败============");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/people/" + label;
    }
}