package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieDouban;
import org.humingk.movie.entity.MovieDoubanExample;

public interface MovieDoubanMapper {
    long countByExample(MovieDoubanExample example);

    int deleteByExample(MovieDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MovieDouban record);

    int insertSelective(MovieDouban record);

    List<MovieDouban> selectByExampleWithBLOBs(MovieDoubanExample example);

    List<MovieDouban> selectByExample(MovieDoubanExample example);

    MovieDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MovieDouban record, @Param("example") MovieDoubanExample example);

    int updateByExampleWithBLOBs(@Param("record") MovieDouban record, @Param("example") MovieDoubanExample example);

    int updateByExample(@Param("record") MovieDouban record, @Param("example") MovieDoubanExample example);

    int updateByPrimaryKeySelective(MovieDouban record);

    int updateByPrimaryKeyWithBLOBs(MovieDouban record);

    int updateByPrimaryKey(MovieDouban record);
}