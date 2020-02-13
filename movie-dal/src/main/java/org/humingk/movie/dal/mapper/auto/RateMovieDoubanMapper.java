package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.RateMovieDouban;
import org.humingk.movie.dal.entity.RateMovieDoubanExample;

@Mapper
public interface RateMovieDoubanMapper {
    long countByExample(RateMovieDoubanExample example);

    int deleteByExample(RateMovieDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RateMovieDouban record);

    int insertSelective(RateMovieDouban record);

    List<RateMovieDouban> selectByExample(RateMovieDoubanExample example);

    RateMovieDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RateMovieDouban record, @Param("example") RateMovieDoubanExample example);

    int updateByExample(@Param("record") RateMovieDouban record, @Param("example") RateMovieDoubanExample example);

    int updateByPrimaryKeySelective(RateMovieDouban record);

    int updateByPrimaryKey(RateMovieDouban record);
}