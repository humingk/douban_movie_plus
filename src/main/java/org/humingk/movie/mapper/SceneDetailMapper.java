package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.SceneDetail;
import org.humingk.movie.entity.SceneDetailExample;

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