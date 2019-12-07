package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ImageMovieDouban;
import org.humingk.movie.entity.ImageMovieDoubanExample;

public interface ImageMovieDoubanMapper {
    long countByExample(ImageMovieDoubanExample example);

    int deleteByExample(ImageMovieDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImageMovieDouban record);

    int insertSelective(ImageMovieDouban record);

    List<ImageMovieDouban> selectByExample(ImageMovieDoubanExample example);

    ImageMovieDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImageMovieDouban record, @Param("example") ImageMovieDoubanExample example);

    int updateByExample(@Param("record") ImageMovieDouban record, @Param("example") ImageMovieDoubanExample example);

    int updateByPrimaryKeySelective(ImageMovieDouban record);

    int updateByPrimaryKey(ImageMovieDouban record);
}