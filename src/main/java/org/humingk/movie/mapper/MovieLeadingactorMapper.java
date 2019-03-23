package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieLeadingactor;

public interface MovieLeadingactorMapper {
    int deleteByPrimaryKey(@Param("movieId") Integer movieId, @Param("leadingactorId") Integer leadingactorId);

    int insert(MovieLeadingactor record);

    List<MovieLeadingactor> selectAll();
}