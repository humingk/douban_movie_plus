package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(String resourceUrl);

    int insert(Resource record);

    Resource selectByPrimaryKey(String resourceUrl);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);
}