package org.humingk.movie.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.humingk.movie.common.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author humin
 */
@Controller
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {

    @RequestMapping(value = "login")
    public ModelAndView login(User user,ModelAndView modelAndView) {
        // Shiro实现登录
        Subject subject = SecurityUtils.getSubject();
        // 封装表单
        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
        try {
            subject.login(token);
            if(subject.hasRole("user")){
                modelAndView.addObject("login", ResultMessage.createMessage(200,"OK",null));
                modelAndView.setViewName("/index");
            }
        }catch (Exception e){
            modelAndView.addObject("login",ResultMessage.createMessage(200,"NO",null));
            modelAndView.setViewName("/login");
            e.printStackTrace();
        }
        return modelAndView;
    }
}
