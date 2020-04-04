package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.ReviewOfMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.douban.ReviewOfMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface ReviewOfMovieDoubanVoConverter
    extends BaseConverter<ReviewOfMovieDoubanVo, ReviewOfMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlReview",
        expression = "java(\"https://movie.douban.com/review/\"+reviewOfMovieDoubanDo.getId())"),
    @Mapping(
        target = "createDatetime",
        source = "createDatetime",
        qualifiedByName = {"util", "unixTimestamp"}),
    @Mapping(
        target = "urlUserDouban",
        source = "userDouban.id",
        qualifiedByName = {"util", "urlUserDouban"}),
    @Mapping(target = "idUserDouban", source = "userDouban.id"),
    @Mapping(target = "nameUserDouban", source = "userDouban.nameZh")
  })
  ReviewOfMovieDoubanVo to(ReviewOfMovieDoubanDo reviewOfMovieDoubanDo);
}
