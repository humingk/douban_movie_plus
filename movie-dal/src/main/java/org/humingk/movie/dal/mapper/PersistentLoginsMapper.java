package org.humingk.movie.dal.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.dal.entity.PersistentLogins;
import org.humingk.movie.dal.entity.PersistentLoginsExample;

@Mapper
public interface PersistentLoginsMapper {
    long countByExample(PersistentLoginsExample example);

    int deleteByExample(PersistentLoginsExample example);

    int deleteByPrimaryKey(String series);

    int insert(PersistentLogins record);

    int insertSelective(PersistentLogins record);

    List<PersistentLogins> selectByExample(PersistentLoginsExample example);

    PersistentLogins selectByPrimaryKey(String series);

    int updateByExampleSelective(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);

    int updateByExample(@Param("record") PersistentLogins record, @Param("example") PersistentLoginsExample example);

    int updateByPrimaryKeySelective(PersistentLogins record);

    int updateByPrimaryKey(PersistentLogins record);
}