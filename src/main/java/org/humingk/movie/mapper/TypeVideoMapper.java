package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.TypeVideo;
import org.humingk.movie.entity.TypeVideoExample;

@Mapper
public interface TypeVideoMapper {
    long countByExample(TypeVideoExample example);

    int deleteByExample(TypeVideoExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(TypeVideo record);

    int insertSelective(TypeVideo record);

    List<TypeVideo> selectByExample(TypeVideoExample example);

    TypeVideo selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") TypeVideo record, @Param("example") TypeVideoExample example);

    int updateByExample(@Param("record") TypeVideo record, @Param("example") TypeVideoExample example);

    int updateByPrimaryKeySelective(TypeVideo record);

    int updateByPrimaryKey(TypeVideo record);
}