package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.User;
import org.humingk.movie.dal.entity.UserExample;

import java.util.List;

@Mapper
public interface UserMapper {
  long countByExample(UserExample example);

  int deleteByExample(UserExample example);

  int deleteByPrimaryKey(String id);

  int insert(User record);

  int insertSelective(User record);

  List<User> selectByExample(UserExample example);

  User selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

  int updateByExample(@Param("record") User record, @Param("example") UserExample example);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);
}
