package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieDoubanToAwardMovie;
import org.humingk.movie.dal.entity.MovieDoubanToAwardMovieExample;

import java.util.List;

@Mapper
public interface MovieDoubanToAwardMovieMapper {
  long countByExample(MovieDoubanToAwardMovieExample example);

  int deleteByExample(MovieDoubanToAwardMovieExample example);

  int deleteByPrimaryKey(
      @Param("idMovieDouban") Long idMovieDouban,
      @Param("idAwardMovie") String idAwardMovie,
      @Param("idCelebrityDouban") Long idCelebrityDouban,
      @Param("typeAward") String typeAward,
      @Param("awardTh") Short awardTh);

  int insert(MovieDoubanToAwardMovie record);

  int insertSelective(MovieDoubanToAwardMovie record);

  List<MovieDoubanToAwardMovie> selectByExample(MovieDoubanToAwardMovieExample example);

  MovieDoubanToAwardMovie selectByPrimaryKey(
      @Param("idMovieDouban") Long idMovieDouban,
      @Param("idAwardMovie") String idAwardMovie,
      @Param("idCelebrityDouban") Long idCelebrityDouban,
      @Param("typeAward") String typeAward,
      @Param("awardTh") Short awardTh);

  int updateByExampleSelective(
      @Param("record") MovieDoubanToAwardMovie record,
      @Param("example") MovieDoubanToAwardMovieExample example);

  int updateByExample(
      @Param("record") MovieDoubanToAwardMovie record,
      @Param("example") MovieDoubanToAwardMovieExample example);

  int updateByPrimaryKeySelective(MovieDoubanToAwardMovie record);

  int updateByPrimaryKey(MovieDoubanToAwardMovie record);
}
