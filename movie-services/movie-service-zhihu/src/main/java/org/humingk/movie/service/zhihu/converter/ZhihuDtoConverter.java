package org.humingk.movie.service.zhihu.converter;

import org.humingk.movie.dal.entity.MovieZhihu;
import org.humingk.movie.dal.entity.QuestionZhihu;
import org.humingk.movie.service.zhihu.dto.ZhihuDto;
import org.mapstruct.Mapper;

import java.util.List;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface ZhihuDtoConverter {
  ZhihuDto to(MovieZhihu movieZhihu, List<QuestionZhihu> questionZhihuList);
}
