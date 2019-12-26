package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.ContinentScene;
import org.humingk.common.entity.ContinentSceneExample;

@Mapper
public interface ContinentSceneMapper {
    long countByExample(ContinentSceneExample example);

    int deleteByExample(ContinentSceneExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(ContinentScene record);

    int insertSelective(ContinentScene record);

    List<ContinentScene> selectByExample(ContinentSceneExample example);

    ContinentScene selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") ContinentScene record, @Param("example") ContinentSceneExample example);

    int updateByExample(@Param("record") ContinentScene record, @Param("example") ContinentSceneExample example);

    int updateByPrimaryKeySelective(ContinentScene record);

    int updateByPrimaryKey(ContinentScene record);
}