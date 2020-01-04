package org.humingk.movie.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.UserToRole;
import org.humingk.movie.dal.entity.UserToRoleExample;

@Mapper
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