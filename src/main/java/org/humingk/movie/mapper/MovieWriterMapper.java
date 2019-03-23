package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieWriter;

public interface MovieWriterMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("writerId") Integer writerId);

    int insert(MovieWriter record);

    List<MovieWriter> selectAll();
}