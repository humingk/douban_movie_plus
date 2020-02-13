package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ReviewMovieDouban;
import org.humingk.movie.dal.entity.ReviewMovieDoubanExample;

@Mapper
public interface ReviewMovieDoubanMapper {
    long countByExample(ReviewMovieDoubanExample example);

    int deleteByExample(ReviewMovieDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReviewMovieDouban record);

    int insertSelective(ReviewMovieDouban record);

    List<ReviewMovieDouban> selectByExampleWithBLOBs(ReviewMovieDoubanExample example);

    List<ReviewMovieDouban> selectByExample(ReviewMovieDoubanExample example);

    ReviewMovieDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReviewMovieDouban record, @Param("example") ReviewMovieDoubanExample example);

    int updateByExampleWithBLOBs(@Param("record") ReviewMovieDouban record, @Param("example") ReviewMovieDoubanExample example);

    int updateByExample(@Param("record") ReviewMovieDouban record, @Param("example") ReviewMovieDoubanExample example);

    int updateByPrimaryKeySelective(ReviewMovieDouban record);

    int updateByPrimaryKeyWithBLOBs(ReviewMovieDouban record);

    int updateByPrimaryKey(ReviewMovieDouban record);
}