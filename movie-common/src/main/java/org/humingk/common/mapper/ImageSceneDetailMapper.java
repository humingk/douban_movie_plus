package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.ImageSceneDetail;
import org.humingk.common.entity.ImageSceneDetailExample;

@Mapper
public interface ImageSceneDetailMapper {
    long countByExample(ImageSceneDetailExample example);

    int deleteByExample(ImageSceneDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImageSceneDetail record);

    int insertSelective(ImageSceneDetail record);

    List<ImageSceneDetail> selectByExample(ImageSceneDetailExample example);

    ImageSceneDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImageSceneDetail record, @Param("example") ImageSceneDetailExample example);

    int updateByExample(@Param("record") ImageSceneDetail record, @Param("example") ImageSceneDetailExample example);

    int updateByPrimaryKeySelective(ImageSceneDetail record);

    int updateByPrimaryKey(ImageSceneDetail record);
}