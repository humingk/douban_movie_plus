package org.humingk.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.Actor;

import java.util.List;

public interface ActorMapper {
    int deleteByPrimaryKey(Integer actorId);

    int insert(Actor record);

    Actor selectByPrimaryKey(Integer actorId);

    List<Actor> selectAll();

    int updateByPrimaryKey(Actor record);

//    -----------------

    void updateActorsByMovieAll(@Param("actorId") int actorId,@Param("name") String name);



    // 根据movieId查找所有的actor

    List<Actor> selectDirectorsByMovieId(Integer movieId);

    List<Actor> selectWritersByMovieId(Integer movieId);

    List<Actor> selectLeadingactorsByMovieId(Integer movieId);
}