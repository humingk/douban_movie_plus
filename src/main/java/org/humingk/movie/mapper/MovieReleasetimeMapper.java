package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieReleasetime;

public interface MovieReleasetimeMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("releasetimeId") Integer releasetimeId);

    int insert(MovieReleasetime record);

    List<MovieReleasetime> selectAll();
}