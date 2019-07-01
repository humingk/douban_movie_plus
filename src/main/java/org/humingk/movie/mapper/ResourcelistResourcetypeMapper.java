package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ResourcelistResourcetype;

public interface ResourcelistResourcetypeMapper {
    int deleteByPrimaryKey(@Param("resourcelistId") Integer resourcelistId, @Param("resourcetypeId") Integer resourcetypeId);

    int insert(ResourcelistResourcetype record);

    List<ResourcelistResourcetype> selectAll();
}