package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.StateScene;
import org.humingk.movie.dal.entity.StateSceneExample;

@Mapper
public interface StateSceneMapper {
    long countByExample(StateSceneExample example);

    int deleteByExample(StateSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StateScene record);

    int insertSelective(StateScene record);

    List<StateScene> selectByExample(StateSceneExample example);

    StateScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StateScene record, @Param("example") StateSceneExample example);

    int updateByExample(@Param("record") StateScene record, @Param("example") StateSceneExample example);

    int updateByPrimaryKeySelective(StateScene record);

    int updateByPrimaryKey(StateScene record);
}