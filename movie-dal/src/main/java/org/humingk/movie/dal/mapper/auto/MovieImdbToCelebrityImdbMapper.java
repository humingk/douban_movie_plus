package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieImdbToCelebrityImdb;
import org.humingk.movie.dal.entity.MovieImdbToCelebrityImdbExample;

import java.util.List;

@Mapper
public interface MovieImdbToCelebrityImdbMapper {
  long countByExample(MovieImdbToCelebrityImdbExample example);

  int deleteByExample(MovieImdbToCelebrityImdbExample example);

  int deleteByPrimaryKey(
      @Param("idMovieImdb") Long idMovieImdb,
      @Param("idCelebrityImdb") Long idCelebrityImdb,
      @Param("idProfession") Byte idProfession);

  int insert(MovieImdbToCelebrityImdb record);

  int insertSelective(MovieImdbToCelebrityImdb record);

  List<MovieImdbToCelebrityImdb> selectByExample(MovieImdbToCelebrityImdbExample example);

  int updateByExampleSelective(
      @Param("record") MovieImdbToCelebrityImdb record,
      @Param("example") MovieImdbToCelebrityImdbExample example);

  int updateByExample(
      @Param("record") MovieImdbToCelebrityImdb record,
      @Param("example") MovieImdbToCelebrityImdbExample example);
}
