package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.ResourcelistResourcetype;

public interface ResourcelistResourcetypeMapper {
    int deleteByPrimaryKey(Integer resourcelistResourcetypeId);

    int insert(ResourcelistResourcetype record);

    ResourcelistResourcetype selectByPrimaryKey(Integer resourcelistResourcetypeId);

    List<ResourcelistResourcetype> selectAll();

    int updateByPrimaryKey(ResourcelistResourcetype record);
}