package org.humingk.movie.service.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.service.common.entity.TypeMovie;
import org.humingk.movie.service.common.entity.TypeMovieExample;

@Mapper
public interface TypeMovieMapper {
    long countByExample(TypeMovieExample example);

    int deleteByExample(TypeMovieExample example);

    int deleteByPrimaryKey(Short id);

    int insert(TypeMovie record);

    int insertSelective(TypeMovie record);

    List<TypeMovie> selectByExample(TypeMovieExample example);

    TypeMovie selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") TypeMovie record, @Param("example") TypeMovieExample example);

    int updateByExample(@Param("record") TypeMovie record, @Param("example") TypeMovieExample example);

    int updateByPrimaryKeySelective(TypeMovie record);

    int updateByPrimaryKey(TypeMovie record);
}