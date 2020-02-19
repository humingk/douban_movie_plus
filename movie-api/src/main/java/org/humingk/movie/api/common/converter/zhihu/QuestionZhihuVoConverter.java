package org.humingk.movie.api.common.converter.zhihu;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.zhihu.QuestionZhihuVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.QuestionZhihu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface QuestionZhihuVoConverter extends BaseConverter<QuestionZhihuVo, QuestionZhihu> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        source = "idMovieDouban",
        qualifiedByName = {"util", "urlMovieDouban"}),
    @Mapping(
        target = "urlZhihuQuestion",
        source = "id",
        qualifiedByName = {"util", "urlZhihuQuestion"}),
  })
  QuestionZhihuVo to(QuestionZhihu questionZhihu);
}
