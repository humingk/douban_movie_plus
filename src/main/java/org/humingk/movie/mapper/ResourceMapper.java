package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    Resource selectByPrimaryKey(Integer resourceId);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);
}