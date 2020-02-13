package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ImageSceneDetail;
import org.humingk.movie.dal.entity.ImageSceneDetailExample;

import java.util.List;

@Mapper
public interface ImageSceneDetailMapper {
  long countByExample(ImageSceneDetailExample example);

  int deleteByExample(ImageSceneDetailExample example);

  int deleteByPrimaryKey(Long id);

  int insert(ImageSceneDetail record);

  int insertSelective(ImageSceneDetail record);

  List<ImageSceneDetail> selectByExample(ImageSceneDetailExample example);

  ImageSceneDetail selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") ImageSceneDetail record, @Param("example") ImageSceneDetailExample example);

  int updateByExample(
      @Param("record") ImageSceneDetail record, @Param("example") ImageSceneDetailExample example);

  int updateByPrimaryKeySelective(ImageSceneDetail record);

  int updateByPrimaryKey(ImageSceneDetail record);
}
