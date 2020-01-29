package org.humingk.movie.dal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.UserToRole;
import org.humingk.movie.dal.entity.UserToRoleExample;

import java.util.List;

@Mapper
public interface UserToRoleMapper {
    long countByExample(UserToRoleExample example);

    int deleteByExample(UserToRoleExample example);

    int deleteByPrimaryKey(@Param("idUser") String idUser, @Param("idRole") Byte idRole);

    int insertSelective(UserToRole record);

    List<UserToRole> selectByExample(UserToRoleExample example);

    int updateByExampleSelective(@Param("record") UserToRole record, @Param("example") UserToRoleExample example);

    int updateByExample(@Param("record") UserToRole record, @Param("example") UserToRoleExample example);

    // ------------

    /**
     * 插入用户-角色关系
     *
     * @param record
     * @return
     */
    int insert(UserToRole record);
}