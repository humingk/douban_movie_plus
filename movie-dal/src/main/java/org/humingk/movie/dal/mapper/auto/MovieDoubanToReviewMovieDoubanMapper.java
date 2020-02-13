package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieDoubanToReviewMovieDouban;
import org.humingk.movie.dal.entity.MovieDoubanToReviewMovieDoubanExample;

import java.util.List;

@Mapper
public interface MovieDoubanToReviewMovieDoubanMapper {
  long countByExample(MovieDoubanToReviewMovieDoubanExample example);

  int deleteByExample(MovieDoubanToReviewMovieDoubanExample example);

  int deleteByPrimaryKey(
      @Param("idMovieDouban") Long idMovieDouban,
      @Param("idReviewMovieDouban") Long idReviewMovieDouban);

  int insert(MovieDoubanToReviewMovieDouban record);

  int insertSelective(MovieDoubanToReviewMovieDouban record);

  List<MovieDoubanToReviewMovieDouban> selectByExample(
      MovieDoubanToReviewMovieDoubanExample example);

  int updateByExampleSelective(
      @Param("record") MovieDoubanToReviewMovieDouban record,
      @Param("example") MovieDoubanToReviewMovieDoubanExample example);

  int updateByExample(
      @Param("record") MovieDoubanToReviewMovieDouban record,
      @Param("example") MovieDoubanToReviewMovieDoubanExample example);
}
