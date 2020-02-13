package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ArtistNeteaseToSongNetease;
import org.humingk.movie.dal.entity.ArtistNeteaseToSongNeteaseExample;

import java.util.List;

@Mapper
public interface ArtistNeteaseToSongNeteaseMapper {
  long countByExample(ArtistNeteaseToSongNeteaseExample example);

  int deleteByExample(ArtistNeteaseToSongNeteaseExample example);

  int deleteByPrimaryKey(
      @Param("idArtistNetease") Long idArtistNetease, @Param("idSongNetease") Long idSongNetease);

  int insert(ArtistNeteaseToSongNetease record);

  int insertSelective(ArtistNeteaseToSongNetease record);

  List<ArtistNeteaseToSongNetease> selectByExample(ArtistNeteaseToSongNeteaseExample example);

  int updateByExampleSelective(
      @Param("record") ArtistNeteaseToSongNetease record,
      @Param("example") ArtistNeteaseToSongNeteaseExample example);

  int updateByExample(
      @Param("record") ArtistNeteaseToSongNetease record,
      @Param("example") ArtistNeteaseToSongNeteaseExample example);
}
