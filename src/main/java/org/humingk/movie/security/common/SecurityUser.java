package org.humingk.movie.security.common;

import lombok.AllArgsConstructor;
import org.humingk.movie.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

/**
 * Spring Security 专用User类
 * <p>
 * 实现UserDetail:    Spring Security认证信息的核心接口,用于获取用户对应的所有的角色
 *
 * @author humingk
 */
@AllArgsConstructor
public class SecurityUser extends User implements UserDetails, Serializable {
    /**
     * 用户对应的角色列表
     */
    private List<SecurityRole> authorities;

    /**
     * 此处实际获取用户登录邮箱
     *
     * @return
     */
    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public List<SecurityRole> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SecurityRole> authorities) {
        this.authorities = authorities;
    }

    /**
     * 账号是否未过期
     *
     * @return true:未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否未被锁定
     *
     * @return true:未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     *
     * @return true:未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     *
     * @return true:可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}