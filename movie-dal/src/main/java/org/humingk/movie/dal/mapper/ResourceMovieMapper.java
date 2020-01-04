package org.humingk.movie.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ResourceMovie;
import org.humingk.movie.dal.entity.ResourceMovieExample;

@Mapper
public interface ResourceMovieMapper {
    long countByExample(ResourceMovieExample example);

    int deleteByExample(ResourceMovieExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ResourceMovie record);

    int insertSelective(ResourceMovie record);

    List<ResourceMovie> selectByExample(ResourceMovieExample example);

    ResourceMovie selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ResourceMovie record, @Param("example") ResourceMovieExample example);

    int updateByExample(@Param("record") ResourceMovie record, @Param("example") ResourceMovieExample example);

    int updateByPrimaryKeySelective(ResourceMovie record);

    int updateByPrimaryKey(ResourceMovie record);
}