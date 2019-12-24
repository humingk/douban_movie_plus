package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.MovieDoubanToCelebrityDouban;
import org.humingk.common.entity.MovieDoubanToCelebrityDoubanExample;

@Mapper
public interface MovieDoubanToCelebrityDoubanMapper {
    long countByExample(MovieDoubanToCelebrityDoubanExample example);

    int deleteByExample(MovieDoubanToCelebrityDoubanExample example);

    int deleteByPrimaryKey(@Param("idMovieDouban") Long idMovieDouban, @Param("idCelebrityDouban") Long idCelebrityDouban, @Param("idProfession") Byte idProfession);

    int insert(MovieDoubanToCelebrityDouban record);

    int insertSelective(MovieDoubanToCelebrityDouban record);

    List<MovieDoubanToCelebrityDouban> selectByExample(MovieDoubanToCelebrityDoubanExample example);

    MovieDoubanToCelebrityDouban selectByPrimaryKey(@Param("idMovieDouban") Long idMovieDouban, @Param("idCelebrityDouban") Long idCelebrityDouban, @Param("idProfession") Byte idProfession);

    int updateByExampleSelective(@Param("record") MovieDoubanToCelebrityDouban record, @Param("example") MovieDoubanToCelebrityDoubanExample example);

    int updateByExample(@Param("record") MovieDoubanToCelebrityDouban record, @Param("example") MovieDoubanToCelebrityDoubanExample example);

    int updateByPrimaryKeySelective(MovieDoubanToCelebrityDouban record);

    int updateByPrimaryKey(MovieDoubanToCelebrityDouban record);
}