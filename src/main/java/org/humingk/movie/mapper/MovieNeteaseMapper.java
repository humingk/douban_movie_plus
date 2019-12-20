package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.MovieNetease;
import org.humingk.movie.entity.MovieNeteaseExample;

@Mapper
public interface MovieNeteaseMapper {
    long countByExample(MovieNeteaseExample example);

    int deleteByExample(MovieNeteaseExample example);

    int deleteByPrimaryKey(@Param("idMovieDouban") Long idMovieDouban, @Param("idNetease") Long idNetease, @Param("neteaseType") Byte neteaseType);

    int insert(MovieNetease record);

    int insertSelective(MovieNetease record);

    List<MovieNetease> selectByExample(MovieNeteaseExample example);

    MovieNetease selectByPrimaryKey(@Param("idMovieDouban") Long idMovieDouban, @Param("idNetease") Long idNetease, @Param("neteaseType") Byte neteaseType);

    int updateByExampleSelective(@Param("record") MovieNetease record, @Param("example") MovieNeteaseExample example);

    int updateByExample(@Param("record") MovieNetease record, @Param("example") MovieNeteaseExample example);

    int updateByPrimaryKeySelective(MovieNetease record);

    int updateByPrimaryKey(MovieNetease record);
}