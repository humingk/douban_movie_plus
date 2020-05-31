package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.zhihu.MovieZhihuVoConverter;
import org.humingk.movie.api.common.converter.zhihu.QuestionZhihuVoConverter;
import org.humingk.movie.api.common.vo.ZhihuVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.zhihu.dto.ZhihuDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {MovieZhihuVoConverter.class, QuestionZhihuVoConverter.class})
public interface ZhihuVoConverter extends BaseConverter<ZhihuVo, ZhihuDto> {
  @Override
  @Mappings({
    @Mapping(target = "topic", source = "movieZhihu"),
    @Mapping(target = "questionList", source = "questionZhihuList")
  })
  ZhihuVo to(ZhihuDto zhihuDto);
}
