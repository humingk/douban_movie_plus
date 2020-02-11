package org.humingk.movie.dal.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户-角色
 *
 *@author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserToRole implements Serializable {
    /**
     * 用户ID
     */
    private String idUser;

    /**
     * 角色ID
     */
    private Byte idRole;

    private static final long serialVersionUID = 1L;
}