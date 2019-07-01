package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ResourceResourcetype;

public interface ResourceResourcetypeMapper {
    int deleteByPrimaryKey(@Param("resourceUrl") String resourceUrl, @Param("resourcetypeId") Integer resourcetypeId);

    int insert(ResourceResourcetype record);

    List<ResourceResourcetype> selectAll();
}