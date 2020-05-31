package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.CelebrityDoubanToClassicDouban;
import org.humingk.movie.dal.entity.CelebrityDoubanToClassicDoubanExample;

@Mapper
public interface CelebrityDoubanToClassicDoubanMapper {
    long countByExample(CelebrityDoubanToClassicDoubanExample example);

    int deleteByExample(CelebrityDoubanToClassicDoubanExample example);

    int deleteByPrimaryKey(@Param("idCelebrityDouban") Long idCelebrityDouban, @Param("idClassicDouban") String idClassicDouban);

    int insert(CelebrityDoubanToClassicDouban record);

    int insertSelective(CelebrityDoubanToClassicDouban record);

    List<CelebrityDoubanToClassicDouban> selectByExample(CelebrityDoubanToClassicDoubanExample example);

    CelebrityDoubanToClassicDouban selectByPrimaryKey(@Param("idCelebrityDouban") Long idCelebrityDouban, @Param("idClassicDouban") String idClassicDouban);

    int updateByExampleSelective(@Param("record") CelebrityDoubanToClassicDouban record, @Param("example") CelebrityDoubanToClassicDoubanExample example);

    int updateByExample(@Param("record") CelebrityDoubanToClassicDouban record, @Param("example") CelebrityDoubanToClassicDoubanExample example);

    int updateByPrimaryKeySelective(CelebrityDoubanToClassicDouban record);

    int updateByPrimaryKey(CelebrityDoubanToClassicDouban record);
}