package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Keyword;

public interface KeywordMapper {
    int deleteByPrimaryKey(String keywordContent);

    int insert(Keyword record);

    Keyword selectByPrimaryKey(String keywordContent);

    List<Keyword> selectAll();

    int updateByPrimaryKey(Keyword record);
}