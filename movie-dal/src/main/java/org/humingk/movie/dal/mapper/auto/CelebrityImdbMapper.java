package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.humingk.movie.dal.entity.CelebrityImdbExample;

import java.util.List;

@Mapper
public interface CelebrityImdbMapper {
  long countByExample(CelebrityImdbExample example);

  int deleteByExample(CelebrityImdbExample example);

  int deleteByPrimaryKey(Long id);

  int insert(CelebrityImdb record);

  int insertSelective(CelebrityImdb record);

  List<CelebrityImdb> selectByExample(CelebrityImdbExample example);

  CelebrityImdb selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") CelebrityImdb record, @Param("example") CelebrityImdbExample example);

  int updateByExample(
      @Param("record") CelebrityImdb record, @Param("example") CelebrityImdbExample example);

  int updateByPrimaryKeySelective(CelebrityImdb record);

  int updateByPrimaryKey(CelebrityImdb record);
}
