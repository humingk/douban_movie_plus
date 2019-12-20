package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.PlaceScene;
import org.humingk.movie.entity.PlaceSceneExample;

@Mapper
public interface PlaceSceneMapper {
    long countByExample(PlaceSceneExample example);

    int deleteByExample(PlaceSceneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PlaceScene record);

    int insertSelective(PlaceScene record);

    List<PlaceScene> selectByExample(PlaceSceneExample example);

    PlaceScene selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlaceScene record, @Param("example") PlaceSceneExample example);

    int updateByExample(@Param("record") PlaceScene record, @Param("example") PlaceSceneExample example);

    int updateByPrimaryKeySelective(PlaceScene record);

    int updateByPrimaryKey(PlaceScene record);
}