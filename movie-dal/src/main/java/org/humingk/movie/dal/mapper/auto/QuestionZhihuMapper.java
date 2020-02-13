package org.humingk.movie.dal.mapper.auto;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.QuestionZhihu;
import org.humingk.movie.dal.entity.QuestionZhihuExample;

import java.util.List;

@Mapper
public interface QuestionZhihuMapper {
  long countByExample(QuestionZhihuExample example);

  int deleteByExample(QuestionZhihuExample example);

  int deleteByPrimaryKey(Long id);

  int insert(QuestionZhihu record);

  int insertSelective(QuestionZhihu record);

  List<QuestionZhihu> selectByExample(QuestionZhihuExample example);

  QuestionZhihu selectByPrimaryKey(Long id);

  int updateByExampleSelective(
      @Param("record") QuestionZhihu record, @Param("example") QuestionZhihuExample example);

  int updateByExample(
      @Param("record") QuestionZhihu record, @Param("example") QuestionZhihuExample example);

  int updateByPrimaryKeySelective(QuestionZhihu record);

  int updateByPrimaryKey(QuestionZhihu record);
}
