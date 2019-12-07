package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.ArtistNeteaseToSongNetease;
import org.humingk.movie.entity.ArtistNeteaseToSongNeteaseExample;

public interface ArtistNeteaseToSongNeteaseMapper {
    long countByExample(ArtistNeteaseToSongNeteaseExample example);

    int deleteByExample(ArtistNeteaseToSongNeteaseExample example);

    int deleteByPrimaryKey(@Param("idArtistNetease") Long idArtistNetease, @Param("idSongNetease") Long idSongNetease);

    int insert(ArtistNeteaseToSongNetease record);

    int insertSelective(ArtistNeteaseToSongNetease record);

    List<ArtistNeteaseToSongNetease> selectByExample(ArtistNeteaseToSongNeteaseExample example);

    int updateByExampleSelective(@Param("record") ArtistNeteaseToSongNetease record, @Param("example") ArtistNeteaseToSongNeteaseExample example);

    int updateByExample(@Param("record") ArtistNeteaseToSongNetease record, @Param("example") ArtistNeteaseToSongNeteaseExample example);
}