package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.UserDoubanToMovieDouban;
import org.humingk.movie.dal.entity.UserDoubanToMovieDoubanExample;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface UserDoubanToMovieDoubanMapper {
  long countByExample(UserDoubanToMovieDoubanExample example);

  int deleteByExample(UserDoubanToMovieDoubanExample example);

  int deleteByPrimaryKey(
      @Param("idUserDouban") String idUserDouban,
      @Param("idMovieDouban") Long idMovieDouban,
      @Param("score") BigDecimal score);

  int insert(UserDoubanToMovieDouban record);

  int insertSelective(UserDoubanToMovieDouban record);

  List<UserDoubanToMovieDouban> selectByExample(UserDoubanToMovieDoubanExample example);

  UserDoubanToMovieDouban selectByPrimaryKey(
      @Param("idUserDouban") String idUserDouban,
      @Param("idMovieDouban") Long idMovieDouban,
      @Param("score") BigDecimal score);

  int updateByExampleSelective(
      @Param("record") UserDoubanToMovieDouban record,
      @Param("example") UserDoubanToMovieDoubanExample example);

  int updateByExample(
      @Param("record") UserDoubanToMovieDouban record,
      @Param("example") UserDoubanToMovieDoubanExample example);

  int updateByPrimaryKeySelective(UserDoubanToMovieDouban record);

  int updateByPrimaryKey(UserDoubanToMovieDouban record);
}
