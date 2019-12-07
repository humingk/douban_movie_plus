package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.TypePlaceScene;
import org.humingk.movie.entity.TypePlaceSceneExample;

public interface TypePlaceSceneMapper {
    long countByExample(TypePlaceSceneExample example);

    int deleteByExample(TypePlaceSceneExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(TypePlaceScene record);

    int insertSelective(TypePlaceScene record);

    List<TypePlaceScene> selectByExample(TypePlaceSceneExample example);

    TypePlaceScene selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") TypePlaceScene record, @Param("example") TypePlaceSceneExample example);

    int updateByExample(@Param("record") TypePlaceScene record, @Param("example") TypePlaceSceneExample example);

    int updateByPrimaryKeySelective(TypePlaceScene record);

    int updateByPrimaryKey(TypePlaceScene record);
}