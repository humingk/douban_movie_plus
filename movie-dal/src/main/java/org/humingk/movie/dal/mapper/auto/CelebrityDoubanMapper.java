package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.CelebrityDouban;
import org.humingk.movie.dal.entity.CelebrityDoubanExample;

@Mapper
public interface CelebrityDoubanMapper {
    long countByExample(CelebrityDoubanExample example);

    int deleteByExample(CelebrityDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CelebrityDouban record);

    int insertSelective(CelebrityDouban record);

    List<CelebrityDouban> selectByExample(CelebrityDoubanExample example);

    CelebrityDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CelebrityDouban record, @Param("example") CelebrityDoubanExample example);

    int updateByExample(@Param("record") CelebrityDouban record, @Param("example") CelebrityDoubanExample example);

    int updateByPrimaryKeySelective(CelebrityDouban record);

    int updateByPrimaryKey(CelebrityDouban record);
}