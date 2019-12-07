package org.humingk.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.humingk.movie.entity.WebsiteResource;
import org.humingk.movie.entity.WebsiteResourceExample;

public interface WebsiteResourceMapper {
    long countByExample(WebsiteResourceExample example);

    int deleteByExample(WebsiteResourceExample example);

    int deleteByPrimaryKey(Short id);

    int insert(WebsiteResource record);

    int insertSelective(WebsiteResource record);

    List<WebsiteResource> selectByExample(WebsiteResourceExample example);

    WebsiteResource selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") WebsiteResource record, @Param("example") WebsiteResourceExample example);

    int updateByExample(@Param("record") WebsiteResource record, @Param("example") WebsiteResourceExample example);

    int updateByPrimaryKeySelective(WebsiteResource record);

    int updateByPrimaryKey(WebsiteResource record);
}