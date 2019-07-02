package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.Resource;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(@Param("resourceUrl") String resourceUrl, @Param("keyword") String keyword);

    int insert(Resource record);

    Resource selectByPrimaryKey(@Param("resourceUrl") String resourceUrl, @Param("keyword") String keyword);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);

    /**
     * 通过keyword获取电影资源集合
     *
     * @param keyword
     * @return
     */
    List<Resource> selectByKeyword(@Param("keyword") String keyword);
}