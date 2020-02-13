package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ArtistNetease;
import org.humingk.movie.dal.entity.ArtistNeteaseExample;

import java.util.List;

@Mapper
public interface ArtistNeteaseMapper {
  long countByExample(ArtistNeteaseExample example);

  int deleteByExample(ArtistNeteaseExample example);

  int deleteByPrimaryKey(Long id);

  int insert(ArtistNetease record);

  int insertSelective(ArtistNetease record);

  List<ArtistNetease> selectByExample(ArtistNeteaseExample example);

  ArtistNetease selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") ArtistNetease record, @Param("example") ArtistNeteaseExample example);

  int updateByExample(
      @Param("record") ArtistNetease record, @Param("example") ArtistNeteaseExample example);

  int updateByPrimaryKeySelective(ArtistNetease record);

  int updateByPrimaryKey(ArtistNetease record);
}
