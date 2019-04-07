package org.humingk.movie.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.humingk.movie.common.JsonUtil;
import org.humingk.movie.entity.User;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义 rememberFilter
 * shiro 默认需要登录操作才能获取用户的session信息，
 * 如果是 rememberMe 访问的话，不能获取session信息
 * <p>
 * 故实现一个过滤器，拦截 rememberMe功能的请求
 *
 * @author humin
 */
public class RememberMeFilter extends FormAuthenticationFilter {

    @Autowired
    private UserService userService;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    /**
     * 没有session的话，添加session currentUser
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();


            // 判断是否为记住我方式访问，并且当前没有session currentUser
            if (!subject.isAuthenticated() && subject.isRemembered() && session.getAttribute("currentUser") == null) {
                Object principal = subject.getPrincipal();
                if (principal != null) {
                    User userInfo = userService.getUserInfoByUserEmail(((User) principal).getEmail());
                    // 添加session currentUser
                    session.setAttribute("currentUser", JsonUtil.toJson(userInfo));
                    System.out.println("rememberMeFilter : 访问方式:[记住我,但没有session] =========================");
                    System.out.println("rememberMeFilter : 添加session currentUser");
                    System.out.println("session sessionID: " + session.getId());
                    System.out.println("session account: " + ((User) subject.getPrincipal()).getEmail());
                    System.out.println("session currentUser: " + session.getAttribute("currentUser").toString());
                }
            }
            // 记住我方式访问，但有session currentUser
            else {
                System.out.println("rememberMeFilter :访问方式: [登录]、[记住我，但有session] =========================");
                System.out.println("session currentUser: " + session.getAttribute("currentUser").toString());
                System.out.println("session sessionID: " + session.getId());
                System.out.println("session account: " + ((User) subject.getPrincipal()).getEmail());
            }
            return subject.isAuthenticated() || subject.isRemembered();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
