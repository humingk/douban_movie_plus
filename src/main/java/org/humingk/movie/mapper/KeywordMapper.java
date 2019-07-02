package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.Keyword;

import java.util.List;

public interface KeywordMapper {
    int deleteByPrimaryKey(String keyword);

    int insert(Keyword record);

    Keyword selectByPrimaryKey(String keyword);

    List<Keyword> selectAll();

    int updateByPrimaryKey(Keyword record);

    int replace(Keyword record);

    /**
     * 更新searchFlag
     *
     * @param keyword
     * @param searchFlag
     * @return
     */
    int updateSearchFlag(@Param("keyword") String keyword, @Param("searchFlag") int searchFlag);

    /**
     * 更新resourceFlag
     *
     * @param keyword
     * @param resourceFlag
     * @return
     */
    int updateResourceFlag(@Param("keyword") String keyword, @Param("resourceFlag") int resourceFlag);
}