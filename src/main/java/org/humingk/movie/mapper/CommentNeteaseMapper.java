package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.CommentNetease;
import org.humingk.movie.entity.CommentNeteaseExample;

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