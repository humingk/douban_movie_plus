package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.ImageCelebrityDouban;
import org.humingk.common.entity.ImageCelebrityDoubanExample;

@Mapper
public interface ImageCelebrityDoubanMapper {
    long countByExample(ImageCelebrityDoubanExample example);

    int deleteByExample(ImageCelebrityDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImageCelebrityDouban record);

    int insertSelective(ImageCelebrityDouban record);

    List<ImageCelebrityDouban> selectByExample(ImageCelebrityDoubanExample example);

    ImageCelebrityDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImageCelebrityDouban record, @Param("example") ImageCelebrityDoubanExample example);

    int updateByExample(@Param("record") ImageCelebrityDouban record, @Param("example") ImageCelebrityDoubanExample example);

    int updateByPrimaryKeySelective(ImageCelebrityDouban record);

    int updateByPrimaryKey(ImageCelebrityDouban record);
}