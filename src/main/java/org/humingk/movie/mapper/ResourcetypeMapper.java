package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Resourcetype;

public interface ResourcetypeMapper {
    int deleteByPrimaryKey(Integer resourcetypeId);

    int insert(Resourcetype record);

    Resourcetype selectByPrimaryKey(Integer resourcetypeId);

    List<Resourcetype> selectAll();

    int updateByPrimaryKey(Resourcetype record);
}