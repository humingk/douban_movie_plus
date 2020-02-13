package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieDoubanToTypeMovie;
import org.humingk.movie.dal.entity.MovieDoubanToTypeMovieExample;

import java.util.List;

@Mapper
public interface MovieDoubanToTypeMovieMapper {
  long countByExample(MovieDoubanToTypeMovieExample example);

  int deleteByExample(MovieDoubanToTypeMovieExample example);

  int deleteByPrimaryKey(
      @Param("idMovieDouban") Long idMovieDouban, @Param("idTypeMovie") Short idTypeMovie);

  int insert(MovieDoubanToTypeMovie record);

  int insertSelective(MovieDoubanToTypeMovie record);

  List<MovieDoubanToTypeMovie> selectByExample(MovieDoubanToTypeMovieExample example);

  int updateByExampleSelective(
      @Param("record") MovieDoubanToTypeMovie record,
      @Param("example") MovieDoubanToTypeMovieExample example);

  int updateByExample(
      @Param("record") MovieDoubanToTypeMovie record,
      @Param("example") MovieDoubanToTypeMovieExample example);
}
