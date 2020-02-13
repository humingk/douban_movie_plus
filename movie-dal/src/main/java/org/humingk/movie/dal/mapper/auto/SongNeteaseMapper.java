package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.SongNetease;
import org.humingk.movie.dal.entity.SongNeteaseExample;

import java.util.List;

@Mapper
public interface SongNeteaseMapper {
  long countByExample(SongNeteaseExample example);

  int deleteByExample(SongNeteaseExample example);

  int deleteByPrimaryKey(Long id);

  int insert(SongNetease record);

  int insertSelective(SongNetease record);

  List<SongNetease> selectByExample(SongNeteaseExample example);

  SongNetease selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") SongNetease record, @Param("example") SongNeteaseExample example);

  int updateByExample(
      @Param("record") SongNetease record, @Param("example") SongNeteaseExample example);

  int updateByPrimaryKeySelective(SongNetease record);

  int updateByPrimaryKey(SongNetease record);
}
