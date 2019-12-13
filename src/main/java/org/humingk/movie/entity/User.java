package org.humingk.movie.entity;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

/**
 * Spring Security 专用User类
 * <p>
 * UserDetail:    实现Spring Security认证信息的核心接口,用于获取用户对应的所有的角色
 *
 * @author humingk
 */
public class User implements UserDetails, Serializable {
    private String id;

    private String email;

    private String password;

    /**
     * 用户对应的角色列表
     */
    private List<Role> authorities;

    /**
     * 此处实际获取用户登录邮箱
     *
     * @return
     */
    @Override
    public String getUsername() {
        return getEmail();
    }

    /**
     * 获取该用户的所有角色
     *
     * @return
     */
    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
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
        return false;
    }

    /**
     * 密码是否未过期
     *
     * @return true:未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 用户是否可用
     *
     * @return true:可用
     */
    @Override
    public boolean isEnabled() {
        return false;
    }


    public User(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }
}