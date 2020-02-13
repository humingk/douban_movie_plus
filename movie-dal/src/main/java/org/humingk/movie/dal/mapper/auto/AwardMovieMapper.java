package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.AwardMovie;
import org.humingk.movie.dal.entity.AwardMovieExample;

import java.util.List;

@Mapper
public interface AwardMovieMapper {
  long countByExample(AwardMovieExample example);

  int deleteByExample(AwardMovieExample example);

  int deleteByPrimaryKey(String id);

  int insert(AwardMovie record);

  int insertSelective(AwardMovie record);

  List<AwardMovie> selectByExample(AwardMovieExample example);

  AwardMovie selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") AwardMovie record, @Param("example") AwardMovieExample example);

  int updateByExample(
      @Param("record") AwardMovie record, @Param("example") AwardMovieExample example);

  int updateByPrimaryKeySelective(AwardMovie record);

  int updateByPrimaryKey(AwardMovie record);
}
