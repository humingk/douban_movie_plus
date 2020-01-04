package org.humingk.movie.service.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.service.common.entity.CelebrityScene;
import org.humingk.movie.service.common.entity.CelebritySceneExample;

@Mapper
public interface CelebritySceneMapper {
    long countByExample(CelebritySceneExample example);

    int deleteByExample(CelebritySceneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CelebrityScene record);

    int insertSelective(CelebrityScene record);

    List<CelebrityScene> selectByExample(CelebritySceneExample example);

    CelebrityScene selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CelebrityScene record, @Param("example") CelebritySceneExample example);

    int updateByExample(@Param("record") CelebrityScene record, @Param("example") CelebritySceneExample example);

    int updateByPrimaryKeySelective(CelebrityScene record);

    int updateByPrimaryKey(CelebrityScene record);
}