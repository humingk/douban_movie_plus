package org.humingk.movie.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.CommentNetease;
import org.humingk.movie.dal.entity.CommentNeteaseExample;

@Mapper
public interface CommentNeteaseMapper {
    long countByExample(CommentNeteaseExample example);

    int deleteByExample(CommentNeteaseExample example);

    int deleteByPrimaryKey(@Param("idSongNetease") Long idSongNetease, @Param("id") Long id);

    int insert(CommentNetease record);

    int insertSelective(CommentNetease record);

    List<CommentNetease> selectByExample(CommentNeteaseExample example);

    CommentNetease selectByPrimaryKey(@Param("idSongNetease") Long idSongNetease, @Param("id") Long id);

    int updateByExampleSelective(@Param("record") CommentNetease record, @Param("example") CommentNeteaseExample example);

    int updateByExample(@Param("record") CommentNetease record, @Param("example") CommentNeteaseExample example);

    int updateByPrimaryKeySelective(CommentNetease record);

    int updateByPrimaryKey(CommentNetease record);
}