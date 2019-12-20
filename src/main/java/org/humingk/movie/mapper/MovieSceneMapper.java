package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieScene;
import org.humingk.movie.entity.MovieSceneExample;

@Mapper
public interface MovieSceneMapper {
    long countByExample(MovieSceneExample example);

    int deleteByExample(MovieSceneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MovieScene record);

    int insertSelective(MovieScene record);

    List<MovieScene> selectByExample(MovieSceneExample example);

    MovieScene selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MovieScene record, @Param("example") MovieSceneExample example);

    int updateByExample(@Param("record") MovieScene record, @Param("example") MovieSceneExample example);

    int updateByPrimaryKeySelective(MovieScene record);

    int updateByPrimaryKey(MovieScene record);
}