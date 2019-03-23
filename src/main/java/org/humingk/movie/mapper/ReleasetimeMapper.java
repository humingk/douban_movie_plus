package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Releasetime;

public interface ReleasetimeMapper {
    int deleteByPrimaryKey(Integer releasetimeId);

    int insert(Releasetime record);

    Releasetime selectByPrimaryKey(Integer releasetimeId);

    List<Releasetime> selectAll();

    int updateByPrimaryKey(Releasetime record);
}