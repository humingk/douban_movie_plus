package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ArtistNeteaseToAlbumNetease;
import org.humingk.movie.dal.entity.ArtistNeteaseToAlbumNeteaseExample;

import java.util.List;

@Mapper
public interface ArtistNeteaseToAlbumNeteaseMapper {
  long countByExample(ArtistNeteaseToAlbumNeteaseExample example);

  int deleteByExample(ArtistNeteaseToAlbumNeteaseExample example);

  int deleteByPrimaryKey(
      @Param("idArtistNetease") Long idArtistNetease, @Param("idAlbumNetease") Long idAlbumNetease);

  int insert(ArtistNeteaseToAlbumNetease record);

  int insertSelective(ArtistNeteaseToAlbumNetease record);

  List<ArtistNeteaseToAlbumNetease> selectByExample(ArtistNeteaseToAlbumNeteaseExample example);

  int updateByExampleSelective(
      @Param("record") ArtistNeteaseToAlbumNetease record,
      @Param("example") ArtistNeteaseToAlbumNeteaseExample example);

  int updateByExample(
      @Param("record") ArtistNeteaseToAlbumNetease record,
      @Param("example") ArtistNeteaseToAlbumNeteaseExample example);
}
