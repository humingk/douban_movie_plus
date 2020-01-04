package org.humingk.movie.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.UserDouban;
import org.humingk.movie.dal.entity.UserDoubanExample;

@Mapper
public interface UserDoubanMapper {
    long countByExample(UserDoubanExample example);

    int deleteByExample(UserDoubanExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserDouban record);

    int insertSelective(UserDouban record);

    List<UserDouban> selectByExample(UserDoubanExample example);

    UserDouban selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserDouban record, @Param("example") UserDoubanExample example);

    int updateByExample(@Param("record") UserDouban record, @Param("example") UserDoubanExample example);

    int updateByPrimaryKeySelective(UserDouban record);

    int updateByPrimaryKey(UserDouban record);
}