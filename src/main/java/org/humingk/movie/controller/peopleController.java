package org.humingk.movie.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.humingk.movie.common.JsonUtil;
import org.humingk.movie.common.ResultMessage;
import org.humingk.movie.common.WishAndSeen;
import org.humingk.movie.entity.User;
import org.humingk.movie.entity.UserMovie;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class PeopleController {

    @Autowired
    private UserService userService;

    private static final String WISH = "wish";
    private static final String SEEN = "seen";
    private static final String COLLECT = "collect";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 响应url路径 people/{userId} or people/{label}
     *区分是用户访问自己的主页还是其他用户的主页
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
            try {
                Subject subject = SecurityUtils.getSubject();
                Session session = subject.getSession();
                // 判断为记住我方式访问
                if (!subject.isAuthenticated() && subject.isRemembered()) {
                    // 判断session是否为空(eg：记住我访问，重新打开浏览器)
                    if (session.getAttribute("currentUser") == null) {
                        Object principal = subject.getPrincipal();
                        if (principal != null) {
                            User userInfo = userService.getUserInfoByUserEmail(((User) principal).getEmail());
                            // 为当前用户 创建seesion currentUser
                            session.setAttribute("currentUser", JsonUtil.toJson(userInfo));

                            logger.info("为当前用户创建session currentUser");
                            logger.info("session sessionID: "+session.getId());
                            logger.info("session account: "+((User)subject.getPrincipal()).getEmail());
                            logger.info("session currentUser: "+session.getAttribute("currentUser").toString());
                        } else {
                            logger.info("当前用户虽然通过 记住我 方式访问，但是未经过shiro验证");
                        }
                    }
                    // session不为空(已经在此页面或其他页面加过session)
                    else{
                        User currentUser=JsonUtil.toBean((String) session.getAttribute("currentUser"),User.class);
                        // 判断为当前用户访问自己的主页
                        if(currentUser.getLabel().equals(labelOrId)){
                            User userinfo=userService.getUserInfoByUserLabel(labelOrId);
                            modelAndView.addObject("userInfo",
                                    ResultMessage.createMessage(200,"OK", JsonUtil.toJson(userinfo)));
                            logger.info("当前用户访问自己的个人主页");
                        }
                        // 当前用户访问其他用户的主页
                        else {
                            logger.info("当前用户访问其他用户个人主页");
                        }
                    }
                }
                // 无论是不是本人，都返回people主页简略信息
                //    昵称
                User userinfo= userService.getUserInfoByUserLabel(labelOrId);
                modelAndView.addObject("userName",
                        ResultMessage.createMessage(200,"OK",userinfo.getName()));
                //    想看和看过的电影
                List<UserMovie> userMovies = userService.getWishsAndSeensByUserLabel(labelOrId);
                modelAndView.addObject("wishsAndSeens",
                        ResultMessage.createMessage(200,"OK",JsonUtil.toJson(userMovies)));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
                logger.info("更新wishs成功");
            } else {
                logger.info("更新wishs失败");
            }
            WishAndSeen seenUtil = new WishAndSeen();
            HashMap<Integer, Integer> seens = seenUtil.getAllMovie(label, COLLECT);
            if (userService.updateWishAndSeen(seens, label, SEEN)) {
                logger.info("更新seens成功");
            } else {
                logger.info("更新seens失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/people/" + label;
    }
}