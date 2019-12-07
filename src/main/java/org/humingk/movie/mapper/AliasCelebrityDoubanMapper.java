package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.AliasCelebrityDouban;
import org.humingk.movie.entity.AliasCelebrityDoubanExample;

public interface AliasCelebrityDoubanMapper {
    long countByExample(AliasCelebrityDoubanExample example);

    int deleteByExample(AliasCelebrityDoubanExample example);

    int deleteByPrimaryKey(@Param("idCelebrityDouban") Long idCelebrityDouban, @Param("nameAlias") String nameAlias);

    int insert(AliasCelebrityDouban record);

    int insertSelective(AliasCelebrityDouban record);

    List<AliasCelebrityDouban> selectByExample(AliasCelebrityDoubanExample example);

    AliasCelebrityDouban selectByPrimaryKey(@Param("idCelebrityDouban") Long idCelebrityDouban, @Param("nameAlias") String nameAlias);

    int updateByExampleSelective(@Param("record") AliasCelebrityDouban record, @Param("example") AliasCelebrityDoubanExample example);

    int updateByExample(@Param("record") AliasCelebrityDouban record, @Param("example") AliasCelebrityDoubanExample example);

    int updateByPrimaryKeySelective(AliasCelebrityDouban record);

    int updateByPrimaryKey(AliasCelebrityDouban record);
}