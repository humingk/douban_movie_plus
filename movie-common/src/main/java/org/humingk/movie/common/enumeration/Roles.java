package org.humingk.movie.common.enumeration;

import lombok.AllArgsConstructor;

/**
 * 用户角色
 *
 * @author humingk
 */
@AllArgsConstructor
public enum Roles {
    /**
     * 管理员角色
     */
    ROOT(1, "ROLE_ROOT"),
    /**
     * 普通用户角色
     */
    USER(2, "ROLE_USER");

    /**
     * 角色ID
     */
    public int id;
    /**
     * 角色名称
     */
    public String name;
}
