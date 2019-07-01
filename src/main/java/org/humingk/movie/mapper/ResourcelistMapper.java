package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Resourcelist;

public interface ResourcelistMapper {
    int deleteByPrimaryKey(Integer resourcelistId);

    int insert(Resourcelist record);

    List<Resourcelist> selectAll();
}