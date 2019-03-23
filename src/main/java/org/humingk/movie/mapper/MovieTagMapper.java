package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieTag;

public interface MovieTagMapper {
    int deleteByPrimaryKey(@Param("tagId") Integer tagId, @Param("movieId") Integer movieId);

    int insert(MovieTag record);

    List<MovieTag> selectAll();
}