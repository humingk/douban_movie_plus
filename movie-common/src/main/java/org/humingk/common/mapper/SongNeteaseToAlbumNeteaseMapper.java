package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.SongNeteaseToAlbumNetease;
import org.humingk.common.entity.SongNeteaseToAlbumNeteaseExample;

@Mapper
public interface SongNeteaseToAlbumNeteaseMapper {
    long countByExample(SongNeteaseToAlbumNeteaseExample example);

    int deleteByExample(SongNeteaseToAlbumNeteaseExample example);

    int deleteByPrimaryKey(@Param("idSongNetease") Long idSongNetease, @Param("idAlbumNetease") Long idAlbumNetease);

    int insert(SongNeteaseToAlbumNetease record);

    int insertSelective(SongNeteaseToAlbumNetease record);

    List<SongNeteaseToAlbumNetease> selectByExample(SongNeteaseToAlbumNeteaseExample example);

    int updateByExampleSelective(@Param("record") SongNeteaseToAlbumNetease record, @Param("example") SongNeteaseToAlbumNeteaseExample example);

    int updateByExample(@Param("record") SongNeteaseToAlbumNetease record, @Param("example") SongNeteaseToAlbumNeteaseExample example);
}