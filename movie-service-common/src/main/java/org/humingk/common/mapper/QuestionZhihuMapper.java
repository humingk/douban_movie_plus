package org.humingk.common.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.common.entity.QuestionZhihu;
import org.humingk.common.entity.QuestionZhihuExample;

@Mapper
public interface QuestionZhihuMapper {
    long countByExample(QuestionZhihuExample example);

    int deleteByExample(QuestionZhihuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuestionZhihu record);

    int insertSelective(QuestionZhihu record);

    List<QuestionZhihu> selectByExample(QuestionZhihuExample example);

    QuestionZhihu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuestionZhihu record, @Param("example") QuestionZhihuExample example);

    int updateByExample(@Param("record") QuestionZhihu record, @Param("example") QuestionZhihuExample example);

    int updateByPrimaryKeySelective(QuestionZhihu record);

    int updateByPrimaryKey(QuestionZhihu record);
}