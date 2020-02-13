package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.UserNetease;
import org.humingk.movie.dal.entity.UserNeteaseExample;

import java.util.List;

@Mapper
public interface UserNeteaseMapper {
  long countByExample(UserNeteaseExample example);

  int deleteByExample(UserNeteaseExample example);

  int deleteByPrimaryKey(Long id);

  int insert(UserNetease record);

  int insertSelective(UserNetease record);

  List<UserNetease> selectByExample(UserNeteaseExample example);

  UserNetease selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") UserNetease record, @Param("example") UserNeteaseExample example);

  int updateByExample(
      @Param("record") UserNetease record, @Param("example") UserNeteaseExample example);

  int updateByPrimaryKeySelective(UserNetease record);

  int updateByPrimaryKey(UserNetease record);
}
