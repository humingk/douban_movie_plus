package org.humingk.movie.dal.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.ClassicDouban;
import org.humingk.movie.dal.entity.ClassicDoubanExample;

@Mapper
public interface ClassicDoubanMapper {
    long countByExample(ClassicDoubanExample example);

    int deleteByExample(ClassicDoubanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassicDouban record);

    int insertSelective(ClassicDouban record);

    List<ClassicDouban> selectByExample(ClassicDoubanExample example);

    ClassicDouban selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassicDouban record, @Param("example") ClassicDoubanExample example);

    int updateByExample(@Param("record") ClassicDouban record, @Param("example") ClassicDoubanExample example);

    int updateByPrimaryKeySelective(ClassicDouban record);

    int updateByPrimaryKey(ClassicDouban record);
}