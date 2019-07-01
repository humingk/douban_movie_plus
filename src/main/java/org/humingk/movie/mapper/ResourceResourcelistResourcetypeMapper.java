package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ResourceResourcelistResourcetype;

public interface ResourceResourcelistResourcetypeMapper {
    int deleteByPrimaryKey(@Param("resourceId") Integer resourceId, @Param("resourcelistResourcetypeId") Integer resourcelistResourcetypeId);

    int insert(ResourceResourcelistResourcetype record);

    List<ResourceResourcelistResourcetype> selectAll();
}