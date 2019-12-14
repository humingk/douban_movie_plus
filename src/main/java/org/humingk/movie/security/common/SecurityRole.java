package org.humingk.movie.security.common;

import org.humingk.movie.entity.Role;
import org.springframework.security.core.GrantedAuthority;

/**
 * Spring Security 专用Role类
 * <p>
 * 实现GrantedAuthority:  用户获取权限认证
 *
 * @author humingk
 */
public class SecurityRole extends Role implements GrantedAuthority {

    /**
     * 获取角色名(权限点)
     *
     * @return
     */
    @Override
    public String getAuthority() {
        return getNameZh();
    }

}