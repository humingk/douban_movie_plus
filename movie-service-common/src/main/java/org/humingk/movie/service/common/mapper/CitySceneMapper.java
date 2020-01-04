package org.humingk.movie.service.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.service.common.entity.CityScene;
import org.humingk.movie.service.common.entity.CitySceneExample;

@Mapper
public interface CitySceneMapper {
    long countByExample(CitySceneExample example);

    int deleteByExample(CitySceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityScene record);

    int insertSelective(CityScene record);

    List<CityScene> selectByExample(CitySceneExample example);

    CityScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityScene record, @Param("example") CitySceneExample example);

    int updateByExample(@Param("record") CityScene record, @Param("example") CitySceneExample example);

    int updateByPrimaryKeySelective(CityScene record);

    int updateByPrimaryKey(CityScene record);
}