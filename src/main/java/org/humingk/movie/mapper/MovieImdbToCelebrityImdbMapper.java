package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieImdbToCelebrityImdb;
import org.humingk.movie.entity.MovieImdbToCelebrityImdbExample;

@Mapper
public interface MovieImdbToCelebrityImdbMapper {
    long countByExample(MovieImdbToCelebrityImdbExample example);

    int deleteByExample(MovieImdbToCelebrityImdbExample example);

    int deleteByPrimaryKey(@Param("idMovieImdb") Long idMovieImdb, @Param("idCelebrityImdb") Long idCelebrityImdb, @Param("idProfession") Byte idProfession);

    int insert(MovieImdbToCelebrityImdb record);

    int insertSelective(MovieImdbToCelebrityImdb record);

    List<MovieImdbToCelebrityImdb> selectByExample(MovieImdbToCelebrityImdbExample example);

    int updateByExampleSelective(@Param("record") MovieImdbToCelebrityImdb record, @Param("example") MovieImdbToCelebrityImdbExample example);

    int updateByExample(@Param("record") MovieImdbToCelebrityImdb record, @Param("example") MovieImdbToCelebrityImdbExample example);
}