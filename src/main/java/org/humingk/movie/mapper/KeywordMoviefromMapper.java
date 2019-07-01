package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.KeywordMoviefrom;

public interface KeywordMoviefromMapper {
    int deleteByPrimaryKey(@Param("keywordId") Integer keywordId, @Param("moviefromId") Integer moviefromId);

    int insert(KeywordMoviefrom record);

    List<KeywordMoviefrom> selectAll();
}