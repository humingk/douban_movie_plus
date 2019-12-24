package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.SongNeteaseToPlaylistNetease;
import org.humingk.common.entity.SongNeteaseToPlaylistNeteaseExample;

@Mapper
public interface SongNeteaseToPlaylistNeteaseMapper {
    long countByExample(SongNeteaseToPlaylistNeteaseExample example);

    int deleteByExample(SongNeteaseToPlaylistNeteaseExample example);

    int deleteByPrimaryKey(@Param("idSongNetease") Long idSongNetease, @Param("idPlaylistNetease") Long idPlaylistNetease);

    int insert(SongNeteaseToPlaylistNetease record);

    int insertSelective(SongNeteaseToPlaylistNetease record);

    List<SongNeteaseToPlaylistNetease> selectByExample(SongNeteaseToPlaylistNeteaseExample example);

    SongNeteaseToPlaylistNetease selectByPrimaryKey(@Param("idSongNetease") Long idSongNetease, @Param("idPlaylistNetease") Long idPlaylistNetease);

    int updateByExampleSelective(@Param("record") SongNeteaseToPlaylistNetease record, @Param("example") SongNeteaseToPlaylistNeteaseExample example);

    int updateByExample(@Param("record") SongNeteaseToPlaylistNetease record, @Param("example") SongNeteaseToPlaylistNeteaseExample example);

    int updateByPrimaryKeySelective(SongNeteaseToPlaylistNetease record);

    int updateByPrimaryKey(SongNeteaseToPlaylistNetease record);
}