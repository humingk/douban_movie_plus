package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieResource;

public interface MovieResourceMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("resourceId") Integer resourceId);

    int insert(MovieResource record);

    List<MovieResource> selectAll();
}