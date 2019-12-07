package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.AliasMovieDouban;
import org.humingk.movie.entity.AliasMovieDoubanExample;

public interface AliasMovieDoubanMapper {
    long countByExample(AliasMovieDoubanExample example);

    int deleteByExample(AliasMovieDoubanExample example);

    int deleteByPrimaryKey(@Param("idMovieDouban") Long idMovieDouban, @Param("nameAlias") String nameAlias);

    int insert(AliasMovieDouban record);

    int insertSelective(AliasMovieDouban record);

    List<AliasMovieDouban> selectByExample(AliasMovieDoubanExample example);

    int updateByExampleSelective(@Param("record") AliasMovieDouban record, @Param("example") AliasMovieDoubanExample example);

    int updateByExample(@Param("record") AliasMovieDouban record, @Param("example") AliasMovieDoubanExample example);
}