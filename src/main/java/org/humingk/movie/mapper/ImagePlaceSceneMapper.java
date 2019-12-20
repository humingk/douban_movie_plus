package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ImagePlaceScene;
import org.humingk.movie.entity.ImagePlaceSceneExample;

@Mapper
public interface ImagePlaceSceneMapper {
    long countByExample(ImagePlaceSceneExample example);

    int deleteByExample(ImagePlaceSceneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImagePlaceScene record);

    int insertSelective(ImagePlaceScene record);

    List<ImagePlaceScene> selectByExample(ImagePlaceSceneExample example);

    ImagePlaceScene selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImagePlaceScene record, @Param("example") ImagePlaceSceneExample example);

    int updateByExample(@Param("record") ImagePlaceScene record, @Param("example") ImagePlaceSceneExample example);

    int updateByPrimaryKeySelective(ImagePlaceScene record);

    int updateByPrimaryKey(ImagePlaceScene record);
}