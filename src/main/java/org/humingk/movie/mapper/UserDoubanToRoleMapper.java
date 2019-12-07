package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserDoubanToRole;
import org.humingk.movie.entity.UserDoubanToRoleExample;

public interface UserDoubanToRoleMapper {
    long countByExample(UserDoubanToRoleExample example);

    int deleteByExample(UserDoubanToRoleExample example);

    int deleteByPrimaryKey(@Param("idUserDouban") String idUserDouban, @Param("idRole") Byte idRole);

    int insert(UserDoubanToRole record);

    int insertSelective(UserDoubanToRole record);

    List<UserDoubanToRole> selectByExample(UserDoubanToRoleExample example);

    int updateByExampleSelective(@Param("record") UserDoubanToRole record, @Param("example") UserDoubanToRoleExample example);

    int updateByExample(@Param("record") UserDoubanToRole record, @Param("example") UserDoubanToRoleExample example);
}