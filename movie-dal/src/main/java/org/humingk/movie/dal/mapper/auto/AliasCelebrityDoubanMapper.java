package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.AliasCelebrityDouban;
import org.humingk.movie.dal.entity.AliasCelebrityDoubanExample;

import java.util.List;

@Mapper
public interface AliasCelebrityDoubanMapper {
  long countByExample(AliasCelebrityDoubanExample example);

  int deleteByExample(AliasCelebrityDoubanExample example);

  int deleteByPrimaryKey(
      @Param("idCelebrityDouban") Long idCelebrityDouban, @Param("nameAlias") String nameAlias);

  int insert(AliasCelebrityDouban record);

  int insertSelective(AliasCelebrityDouban record);

  List<AliasCelebrityDouban> selectByExample(AliasCelebrityDoubanExample example);

  AliasCelebrityDouban selectByPrimaryKey(
      @Param("idCelebrityDouban") Long idCelebrityDouban, @Param("nameAlias") String nameAlias);

  int updateByExampleSelective(
      @Param("record") AliasCelebrityDouban record,
      @Param("example") AliasCelebrityDoubanExample example);

  int updateByExample(
      @Param("record") AliasCelebrityDouban record,
      @Param("example") AliasCelebrityDoubanExample example);

  int updateByPrimaryKeySelective(AliasCelebrityDouban record);

  int updateByPrimaryKey(AliasCelebrityDouban record);
}
