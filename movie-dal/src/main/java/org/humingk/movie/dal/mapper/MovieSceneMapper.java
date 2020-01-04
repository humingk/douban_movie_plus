package org.humingk.movie.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieScene;
import org.humingk.movie.dal.entity.MovieSceneExample;

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