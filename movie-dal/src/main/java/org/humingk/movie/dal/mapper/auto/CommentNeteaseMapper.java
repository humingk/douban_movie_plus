package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.CommentNetease;
import org.humingk.movie.dal.entity.CommentNeteaseExample;

import java.util.List;

@Mapper
public interface CommentNeteaseMapper {
  long countByExample(CommentNeteaseExample example);

  int deleteByExample(CommentNeteaseExample example);

  int deleteByPrimaryKey(@Param("idSongNetease") Long idSongNetease, @Param("id") Long id);

  int insert(CommentNetease record);

  int insertSelective(CommentNetease record);

  List<CommentNetease> selectByExample(CommentNeteaseExample example);

  CommentNetease selectByPrimaryKey(
      @Param("idSongNetease") Long idSongNetease, @Param("id") Long id);

  int updateByExampleSelective(
      @Param("record") CommentNetease record, @Param("example") CommentNeteaseExample example);

  int updateByExample(
      @Param("record") CommentNetease record, @Param("example") CommentNeteaseExample example);

  int updateByPrimaryKeySelective(CommentNetease record);

  int updateByPrimaryKey(CommentNetease record);
}
