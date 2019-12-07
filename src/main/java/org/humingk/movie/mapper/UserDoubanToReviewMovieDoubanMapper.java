package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.UserDoubanToReviewMovieDouban;
import org.humingk.movie.entity.UserDoubanToReviewMovieDoubanExample;

public interface UserDoubanToReviewMovieDoubanMapper {
    long countByExample(UserDoubanToReviewMovieDoubanExample example);

    int deleteByExample(UserDoubanToReviewMovieDoubanExample example);

    int deleteByPrimaryKey(@Param("idUserDouban") String idUserDouban, @Param("idReviewMovieDouban") Long idReviewMovieDouban);

    int insert(UserDoubanToReviewMovieDouban record);

    int insertSelective(UserDoubanToReviewMovieDouban record);

    List<UserDoubanToReviewMovieDouban> selectByExample(UserDoubanToReviewMovieDoubanExample example);

    int updateByExampleSelective(@Param("record") UserDoubanToReviewMovieDouban record, @Param("example") UserDoubanToReviewMovieDoubanExample example);

    int updateByExample(@Param("record") UserDoubanToReviewMovieDouban record, @Param("example") UserDoubanToReviewMovieDoubanExample example);
}