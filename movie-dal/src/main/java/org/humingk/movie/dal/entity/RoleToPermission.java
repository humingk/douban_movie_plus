package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色-权限
 *
 *@author humingk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleToPermission implements Serializable {
    /**
     * 角色ID
     */
    private Byte idRole;

    /**
     * 权限ID
     */
    private Integer idPermission;

    private static final long serialVersionUID = 1L;
}