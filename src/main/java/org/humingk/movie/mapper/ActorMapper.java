package org.humingk.movie.mapper;

import java.util.List;
import org.humingk.movie.entity.Actor;

public interface ActorMapper {
    int deleteByPrimaryKey(Integer actorId);

    int insert(Actor record);

    Actor selectByPrimaryKey(Integer actorId);

    List<Actor> selectAll();

    int updateByPrimaryKey(Actor record);
}