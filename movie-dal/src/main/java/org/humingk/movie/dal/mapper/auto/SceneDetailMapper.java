package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.SceneDetail;
import org.humingk.movie.dal.entity.SceneDetailExample;

@Mapper
public interface SceneDetailMapper {
    long countByExample(SceneDetailExample example);

    int deleteByExample(SceneDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SceneDetail record);

    int insertSelective(SceneDetail record);

    List<SceneDetail> selectByExample(SceneDetailExample example);

    SceneDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SceneDetail record, @Param("example") SceneDetailExample example);

    int updateByExample(@Param("record") SceneDetail record, @Param("example") SceneDetailExample example);

    int updateByPrimaryKeySelective(SceneDetail record);

    int updateByPrimaryKey(SceneDetail record);
}