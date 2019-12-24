package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.ArtistNeteaseToSongNetease;
import org.humingk.common.entity.ArtistNeteaseToSongNeteaseExample;

@Mapper
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