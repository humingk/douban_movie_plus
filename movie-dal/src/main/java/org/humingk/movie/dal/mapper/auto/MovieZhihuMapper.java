package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.MovieZhihu;
import org.humingk.movie.dal.entity.MovieZhihuExample;

@Mapper
public interface MovieZhihuMapper {
    long countByExample(MovieZhihuExample example);

    int deleteByExample(MovieZhihuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MovieZhihu record);

    int insertSelective(MovieZhihu record);

    List<MovieZhihu> selectByExample(MovieZhihuExample example);

    MovieZhihu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MovieZhihu record, @Param("example") MovieZhihuExample example);

    int updateByExample(@Param("record") MovieZhihu record, @Param("example") MovieZhihuExample example);

    int updateByPrimaryKeySelective(MovieZhihu record);

    int updateByPrimaryKey(MovieZhihu record);
}