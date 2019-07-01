package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.KeywordResourcelist;

public interface KeywordResourcelistMapper {
    int deleteByPrimaryKey(@Param("keywordId") Integer keywordId, @Param("resourcelistId") Integer resourcelistId);

    int insert(KeywordResourcelist record);

    List<KeywordResourcelist> selectAll();
}