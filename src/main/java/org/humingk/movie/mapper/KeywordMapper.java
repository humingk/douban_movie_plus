package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Keyword;

public interface KeywordMapper {
    int deleteByPrimaryKey(Integer keywordId);

    int insert(Keyword record);

    Keyword selectByPrimaryKey(Integer keywordId);

    List<Keyword> selectAll();

    int updateByPrimaryKey(Keyword record);
}