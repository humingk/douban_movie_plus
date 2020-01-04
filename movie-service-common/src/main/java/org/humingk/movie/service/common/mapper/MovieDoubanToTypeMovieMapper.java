package org.humingk.movie.service.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.service.common.entity.MovieDoubanToTypeMovie;
import org.humingk.movie.service.common.entity.MovieDoubanToTypeMovieExample;

@Mapper
public interface MovieDoubanToTypeMovieMapper {
    long countByExample(MovieDoubanToTypeMovieExample example);

    int deleteByExample(MovieDoubanToTypeMovieExample example);

    int deleteByPrimaryKey(@Param("idMovieDouban") Long idMovieDouban, @Param("idTypeMovie") Short idTypeMovie);

    int insert(MovieDoubanToTypeMovie record);

    int insertSelective(MovieDoubanToTypeMovie record);

    List<MovieDoubanToTypeMovie> selectByExample(MovieDoubanToTypeMovieExample example);

    int updateByExampleSelective(@Param("record") MovieDoubanToTypeMovie record, @Param("example") MovieDoubanToTypeMovieExample example);

    int updateByExample(@Param("record") MovieDoubanToTypeMovie record, @Param("example") MovieDoubanToTypeMovieExample example);
}