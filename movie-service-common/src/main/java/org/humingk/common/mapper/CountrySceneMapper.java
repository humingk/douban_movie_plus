package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.CountryScene;
import org.humingk.common.entity.CountrySceneExample;

@Mapper
public interface CountrySceneMapper {
    long countByExample(CountrySceneExample example);

    int deleteByExample(CountrySceneExample example);

    int deleteByPrimaryKey(Short id);

    int insert(CountryScene record);

    int insertSelective(CountryScene record);

    List<CountryScene> selectByExample(CountrySceneExample example);

    CountryScene selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") CountryScene record, @Param("example") CountrySceneExample example);

    int updateByExample(@Param("record") CountryScene record, @Param("example") CountrySceneExample example);

    int updateByPrimaryKeySelective(CountryScene record);

    int updateByPrimaryKey(CountryScene record);
}