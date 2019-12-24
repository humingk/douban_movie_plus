package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.TrailerMovieDouban;
import org.humingk.common.entity.TrailerMovieDoubanExample;

@Mapper
public interface TrailerMovieDoubanMapper {
    long countByExample(TrailerMovieDoubanExample example);

    int deleteByExample(TrailerMovieDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrailerMovieDouban record);

    int insertSelective(TrailerMovieDouban record);

    List<TrailerMovieDouban> selectByExample(TrailerMovieDoubanExample example);

    TrailerMovieDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TrailerMovieDouban record, @Param("example") TrailerMovieDoubanExample example);

    int updateByExample(@Param("record") TrailerMovieDouban record, @Param("example") TrailerMovieDoubanExample example);

    int updateByPrimaryKeySelective(TrailerMovieDouban record);

    int updateByPrimaryKey(TrailerMovieDouban record);
}