package org.humingk.movie.controller;

import org.humingk.movie.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

/**
 * @author humin
 */
@RequestMapping(value = "/")
public class PermissionController {

    /**
     * 权限认证
     * @return
     */
    @RequestMapping(value = "check/**")
    public String check(HttpSession session){
        Subject subject=(Subject)session.getAttribute("user");
        User user=(User)subject.getPrincipals();
        return "index";
    }


    /**
     * 有权限访问个人主页
     * @return
     */
    @RequestMapping(value = "people/**")
    public String people(){
        return "people";
    }

    /**
     * 有权限访问管理员页面
     * @return
     */
    @RequestMapping(value = "admin/**")
    public String admin(){
        return "admin";
    }

    /**
     * 没有权限跳转页
     * @return
     */
    @RequestMapping(value = "noPermission/**")
    public String noPermission(){
        return "noPermission";
    }

    /**
     * 个人权限认证失败跳转页
     * @return
     */
    @RequestMapping(value = "unauthor/**")
    public String unauthor(){
        return "unauthor";
    }
}
