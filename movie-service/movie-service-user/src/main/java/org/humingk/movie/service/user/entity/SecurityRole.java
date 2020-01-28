package org.humingk.movie.service.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.humingk.movie.dal.entity.Role;
import org.springframework.security.core.GrantedAuthority;

/**
 * Spring Security 专用Role类
 * <p>
 * 实现GrantedAuthority:  用户获取权限认证
 *
 * @author humingk
 */
@Data
@AllArgsConstructor
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

    public SecurityRole(Role role) {
        super(role.getId(), role.getNameZh(), role.getDescription());
    }

}