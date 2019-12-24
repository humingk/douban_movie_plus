package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.MovieZhihu;
import org.humingk.common.entity.MovieZhihuExample;

@Mapper
public interface MovieZhihuMapper {
    long countByExample(MovieZhihuExample example);

    int deleteByExample(MovieZhihuExample example);

    int deleteByPrimaryKey(@Param("id") Long id, @Param("idMovieDouban") Long idMovieDouban);

    int insert(MovieZhihu record);

    int insertSelective(MovieZhihu record);

    List<MovieZhihu> selectByExample(MovieZhihuExample example);

    MovieZhihu selectByPrimaryKey(@Param("id") Long id, @Param("idMovieDouban") Long idMovieDouban);

    int updateByExampleSelective(@Param("record") MovieZhihu record, @Param("example") MovieZhihuExample example);

    int updateByExample(@Param("record") MovieZhihu record, @Param("example") MovieZhihuExample example);

    int updateByPrimaryKeySelective(MovieZhihu record);

    int updateByPrimaryKey(MovieZhihu record);
}