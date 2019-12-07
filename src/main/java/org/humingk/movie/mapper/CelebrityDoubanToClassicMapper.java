package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.CelebrityDoubanToClassic;
import org.humingk.movie.entity.CelebrityDoubanToClassicExample;

public interface CelebrityDoubanToClassicMapper {
    long countByExample(CelebrityDoubanToClassicExample example);

    int deleteByExample(CelebrityDoubanToClassicExample example);

    int deleteByPrimaryKey(@Param("idCelebrityDouban") Long idCelebrityDouban, @Param("idClassicDouban") Long idClassicDouban);

    int insert(CelebrityDoubanToClassic record);

    int insertSelective(CelebrityDoubanToClassic record);

    List<CelebrityDoubanToClassic> selectByExample(CelebrityDoubanToClassicExample example);

    int updateByExampleSelective(@Param("record") CelebrityDoubanToClassic record, @Param("example") CelebrityDoubanToClassicExample example);

    int updateByExample(@Param("record") CelebrityDoubanToClassic record, @Param("example") CelebrityDoubanToClassicExample example);
}