package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserToRole;
import org.humingk.movie.entity.UserToRoleExample;

public interface UserToRoleMapper {
    long countByExample(UserToRoleExample example);

    int deleteByExample(UserToRoleExample example);

    int deleteByPrimaryKey(@Param("idUser") String idUser, @Param("idRole") Byte idRole);

    int insert(UserToRole record);

    int insertSelective(UserToRole record);

    List<UserToRole> selectByExample(UserToRoleExample example);

    int updateByExampleSelective(@Param("record") UserToRole record, @Param("example") UserToRoleExample example);

    int updateByExample(@Param("record") UserToRole record, @Param("example") UserToRoleExample example);
}