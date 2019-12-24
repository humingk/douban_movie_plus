package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.PlaylistNetease;
import org.humingk.common.entity.PlaylistNeteaseExample;

@Mapper
public interface PlaylistNeteaseMapper {
    long countByExample(PlaylistNeteaseExample example);

    int deleteByExample(PlaylistNeteaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PlaylistNetease record);

    int insertSelective(PlaylistNetease record);

    List<PlaylistNetease> selectByExample(PlaylistNeteaseExample example);

    PlaylistNetease selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlaylistNetease record, @Param("example") PlaylistNeteaseExample example);

    int updateByExample(@Param("record") PlaylistNetease record, @Param("example") PlaylistNeteaseExample example);

    int updateByPrimaryKeySelective(PlaylistNetease record);

    int updateByPrimaryKey(PlaylistNetease record);
}