package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.Search;

import java.util.List;

public interface SearchMapper {
    int deleteByPrimaryKey(@Param("movieUrl") String movieUrl, @Param("keyword") String keyword);

    int insert(Search record);

    Search selectByPrimaryKey(@Param("movieUrl") String movieUrl, @Param("keyword") String keyword);

    List<Search> selectAll();

    int updateByPrimaryKey(Search record);

    /**
     * 通过关键字查找搜索结果集合
     *
     * @param keyword
     * @return
     */
    List<Search> selectByKeyword(@Param("keyword") String keyword);
}