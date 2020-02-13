package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.CommentMovieDouban;
import org.humingk.movie.dal.entity.CommentMovieDoubanExample;

import java.util.List;

@Mapper
public interface CommentMovieDoubanMapper {
  long countByExample(CommentMovieDoubanExample example);

  int deleteByExample(CommentMovieDoubanExample example);

  int deleteByPrimaryKey(
      @Param("idMovieDouban") Long idMovieDouban, @Param("idUserDouban") String idUserDouban);

  int insert(CommentMovieDouban record);

  int insertSelective(CommentMovieDouban record);

  List<CommentMovieDouban> selectByExample(CommentMovieDoubanExample example);

  CommentMovieDouban selectByPrimaryKey(
      @Param("idMovieDouban") Long idMovieDouban, @Param("idUserDouban") String idUserDouban);

  int updateByExampleSelective(
      @Param("record") CommentMovieDouban record,
      @Param("example") CommentMovieDoubanExample example);

  int updateByExample(
      @Param("record") CommentMovieDouban record,
      @Param("example") CommentMovieDoubanExample example);

  int updateByPrimaryKeySelective(CommentMovieDouban record);

  int updateByPrimaryKey(CommentMovieDouban record);
}
