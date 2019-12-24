package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.AlbumNetease;
import org.humingk.common.entity.AlbumNeteaseExample;

@Mapper
public interface AlbumNeteaseMapper {
    long countByExample(AlbumNeteaseExample example);

    int deleteByExample(AlbumNeteaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlbumNetease record);

    int insertSelective(AlbumNetease record);

    List<AlbumNetease> selectByExample(AlbumNeteaseExample example);

    AlbumNetease selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlbumNetease record, @Param("example") AlbumNeteaseExample example);

    int updateByExample(@Param("record") AlbumNetease record, @Param("example") AlbumNeteaseExample example);

    int updateByPrimaryKeySelective(AlbumNetease record);

    int updateByPrimaryKey(AlbumNetease record);
}