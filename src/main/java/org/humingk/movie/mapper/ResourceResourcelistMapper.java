package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ResourceResourcelist;

public interface ResourceResourcelistMapper {
    int deleteByPrimaryKey(@Param("resourceUrl") String resourceUrl, @Param("resourcelistId") Integer resourcelistId);

    int insert(ResourceResourcelist record);

    List<ResourceResourcelist> selectAll();
}