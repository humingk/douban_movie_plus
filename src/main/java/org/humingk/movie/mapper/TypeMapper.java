package org.humingk.movie.mapper;

import org.humingk.movie.entity.Type;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    Type selectByPrimaryKey(Integer typeId);

    List<Type> selectAll();

    int updateByPrimaryKey(Type record);

//    -----------------

    List<Type> selectTypesOfMovieById(Integer movieId);

    Type selectTypesByTypeName(String typeName);
}