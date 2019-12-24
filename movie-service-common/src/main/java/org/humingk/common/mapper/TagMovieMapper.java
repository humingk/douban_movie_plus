package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.TagMovie;
import org.humingk.common.entity.TagMovieExample;

@Mapper
public interface TagMovieMapper {
    long countByExample(TagMovieExample example);

    int deleteByExample(TagMovieExample example);

    int deleteByPrimaryKey(@Param("idMovieDouban") Long idMovieDouban, @Param("nameZh") String nameZh);

    int insert(TagMovie record);

    int insertSelective(TagMovie record);

    List<TagMovie> selectByExample(TagMovieExample example);

    int updateByExampleSelective(@Param("record") TagMovie record, @Param("example") TagMovieExample example);

    int updateByExample(@Param("record") TagMovie record, @Param("example") TagMovieExample example);
}