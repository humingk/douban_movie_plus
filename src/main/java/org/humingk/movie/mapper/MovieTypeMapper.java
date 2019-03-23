package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieType;

public interface MovieTypeMapper {
    int deleteByPrimaryKey(@Param("typeId") Integer typeId, @Param("movieId") Integer movieId);

    int insert(MovieType record);

    List<MovieType> selectAll();
}