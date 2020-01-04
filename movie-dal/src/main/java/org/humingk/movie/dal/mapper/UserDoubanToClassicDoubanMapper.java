package org.humingk.movie.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.UserDoubanToClassicDouban;
import org.humingk.movie.dal.entity.UserDoubanToClassicDoubanExample;

@Mapper
public interface UserDoubanToClassicDoubanMapper {
    long countByExample(UserDoubanToClassicDoubanExample example);

    int deleteByExample(UserDoubanToClassicDoubanExample example);

    int deleteByPrimaryKey(@Param("idUserDouban") String idUserDouban, @Param("idClassicDouban") Long idClassicDouban);

    int insert(UserDoubanToClassicDouban record);

    int insertSelective(UserDoubanToClassicDouban record);

    List<UserDoubanToClassicDouban> selectByExample(UserDoubanToClassicDoubanExample example);

    UserDoubanToClassicDouban selectByPrimaryKey(@Param("idUserDouban") String idUserDouban, @Param("idClassicDouban") Long idClassicDouban);

    int updateByExampleSelective(@Param("record") UserDoubanToClassicDouban record, @Param("example") UserDoubanToClassicDoubanExample example);

    int updateByExample(@Param("record") UserDoubanToClassicDouban record, @Param("example") UserDoubanToClassicDoubanExample example);

    int updateByPrimaryKeySelective(UserDoubanToClassicDouban record);

    int updateByPrimaryKey(UserDoubanToClassicDouban record);
}