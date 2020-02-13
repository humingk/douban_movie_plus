package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.TrailerMovieDouban;
import org.humingk.movie.dal.entity.TrailerMovieDoubanExample;

import java.util.List;

@Mapper
public interface TrailerMovieDoubanMapper {
  long countByExample(TrailerMovieDoubanExample example);

  int deleteByExample(TrailerMovieDoubanExample example);

  int deleteByPrimaryKey(Long id);

  int insert(TrailerMovieDouban record);

  int insertSelective(TrailerMovieDouban record);

  List<TrailerMovieDouban> selectByExample(TrailerMovieDoubanExample example);

  TrailerMovieDouban selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") TrailerMovieDouban record,
      @Param("example") TrailerMovieDoubanExample example);

  int updateByExample(
      @Param("record") TrailerMovieDouban record,
      @Param("example") TrailerMovieDoubanExample example);

  int updateByPrimaryKeySelective(TrailerMovieDouban record);

  int updateByPrimaryKey(TrailerMovieDouban record);
}
