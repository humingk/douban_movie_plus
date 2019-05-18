package org.humingk.movie.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.humingk.movie.TestBase;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserControllerTest extends TestBase {

    @Test
    @RequestMapping("login")
    public void login() {
//        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
//        Factory<SecurityManager> factory =
//        new IniSecurityManagerFactory("classpath:shiroTest.ini");
//
//        //2、得到SecurityManager实例 并绑定给SecurityUtils
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//
//        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken("hukk@qq.com", "1233");
//
////        UsernamePasswordToken token = new UsernamePasswordToken("hukk@qq.com", "123");
////        UsernamePasswordToken token = new UsernamePasswordToken("hu@qq.com", "1233");

        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("hukk@qq.com","1233");
//        UsernamePasswordToken token=new UsernamePasswordToken("hukk@qq.com","1233");
//        UsernamePasswordToken token=new UsernamePasswordToken("hukk@qq.com","1233");


        try {
            //4、身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            System.out.println("登陆失败");
        }

        // 断言用户已经登录
        System.out.println("isLogin:");
        System.out.println(subject.isAuthenticated());
        // 断言用户是普通用户
        System.out.println("isUser:");
        System.out.println(subject.hasRole("user"));
        // 断言用户是管理员
        System.out.println("isAdmin:");
        System.out.println(subject.hasRole("admin"));


        //6、退出
        subject.logout();
    }
}