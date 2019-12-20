package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ArtistNeteaseToAlbumNetease;
import org.humingk.movie.entity.ArtistNeteaseToAlbumNeteaseExample;

@Mapper
public interface ArtistNeteaseToAlbumNeteaseMapper {
    long countByExample(ArtistNeteaseToAlbumNeteaseExample example);

    int deleteByExample(ArtistNeteaseToAlbumNeteaseExample example);

    int deleteByPrimaryKey(@Param("idArtistNetease") Long idArtistNetease, @Param("idAlbumNetease") Long idAlbumNetease);

    int insert(ArtistNeteaseToAlbumNetease record);

    int insertSelective(ArtistNeteaseToAlbumNetease record);

    List<ArtistNeteaseToAlbumNetease> selectByExample(ArtistNeteaseToAlbumNeteaseExample example);

    int updateByExampleSelective(@Param("record") ArtistNeteaseToAlbumNetease record, @Param("example") ArtistNeteaseToAlbumNeteaseExample example);

    int updateByExample(@Param("record") ArtistNeteaseToAlbumNetease record, @Param("example") ArtistNeteaseToAlbumNeteaseExample example);
}