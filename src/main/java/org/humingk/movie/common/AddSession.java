package org.humingk.movie.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.humingk.movie.entity.User;
import org.humingk.movie.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * session工具类
 * 判断当前url页面通过rememberMe访问的时候
 * 是否有session，没有session的话添加一个
 *
 * @author humingk
 */
public class AddSession {

    private static final Logger logger = LoggerFactory.getLogger(AddSession.class);

    /**
     * 没有的话添加一个
     * @return
     */
    public static boolean add(UserService userService) {
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
                        logger.info("session sessionID: " + session.getId());
                        logger.info("session account: " + ((User) subject.getPrincipal()).getEmail());
                        logger.info("session currentUser: " + session.getAttribute("currentUser").toString());

                        return true;
                    } else {
                        logger.info("当前用户虽然通过 记住我 方式访问，但是未经过shiro验证");
                        return false;
                    }
                }
            }
        }catch (Exception e){
            logger.error("",e);
        }
        return false;
    }
}
