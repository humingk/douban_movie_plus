package org.humingk.movie.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.humingk.movie.common.ResultMessage;
import org.humingk.movie.entity.User;
import org.humingk.movie.service.ShiroService;
import org.humingk.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * @author humin
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private ShiroService shiroService;
    @Autowired
    private UserService userService;

    private static final String USER = "user";
    private static final String ADMIN = "admin";

    /**
     * 登录表单处理
     *
     * @param email
     * @param password
     * @param session
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "loginForm",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              HttpSession session, ModelAndView modelAndView) {
        if ("".equals(email)) {
            modelAndView.addObject("login", ResultMessage.createMessage(200, "null email", null));
            modelAndView.setViewName("login");
        }
        // Shiro 实现登录
        Subject subject = SecurityUtils.getSubject();
        // 封装表单,存入shiro的token
        UsernamePasswordToken token = new UsernamePasswordToken(email, password);
//        User user=shiroService.getUserByUserEmail(email);
        User user = userService.getUserByUserEmail(email);
        try {
            subject.login(token);
            // 管理员用户
            if (subject.hasRole(ADMIN)) {
                modelAndView.setViewName("redirect:/people/" + user.getLabel());
            }
            // 普通注册用户
            else if (subject.hasRole(USER)) {
                // 普通用户有域名
                if (user.getLabel() != null) {
                    modelAndView.setViewName("redirect:/people/" + user.getLabel());
                }
                // 普通用户没有域名 只有ID
                else {
                    modelAndView.setViewName("redirect:/people/" + user.getUserId());
                }
            }
        } catch (AuthenticationException e) {
            // 登陆失败
            modelAndView.setViewName("redirect:/login");
            e.printStackTrace();
        }
        return modelAndView;
    }

    /**
     * 用户注册
     *
     * @param email
     * @param label
     * @param password
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/registerForm",method = RequestMethod.POST)
    public ModelAndView register(@RequestParam("email") String email,
                                 @RequestParam("name") String name,
                                 @RequestParam("label") String label,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("password") String password,
                                 ModelAndView modelAndView){
        try{
            User user=new User(email,label,name,password,phone);
            shiroService.insertNormalUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        modelAndView.setViewName("redirect:/people/"+label);
        return modelAndView;
    }

    /**
     * 响应url路径 people/{userId} or people/{label}
     *
     * @param modelAndView
     * @param labelOrId
     * @return
     */
    @RequestMapping(value = "people/{labelOrId}")
    public ModelAndView people(ModelAndView modelAndView, @PathVariable String labelOrId) {
        String pattern = "\\d+";
        // labelOrId 是ID
        if (Pattern.matches(pattern, labelOrId)) {

        }
        // labelOrId 是label
        else {

        }
        modelAndView.setViewName("people");
        return modelAndView;
    }


    /**
     * 登录页面 url处理
     *
     * @return
     */
    @RequestMapping(value = "login")
    public String loginPage() {
        return "login";
    }

    /**
     * 有权限访问个人主页
     *
     * @return
     */
    @RequestMapping(value = "people")
    public String people() {
        return "people";
    }

    /**
     * 个人权限认证失败跳转页
     *
     * @return
     */
    @RequestMapping(value = "unauthor")
    public String unauthor() {
        return "unauthor";
    }

    /**
     * 没有权限跳转页
     *
     * @return
     */
    @RequestMapping(value = "noPermission/**")
    public String noPermission() {
        return "noPermission";
    }

}
