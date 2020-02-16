package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.ReviewMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.ReviewMovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface ReviewMovieDoubanVoConverter
    extends BaseConverter<ReviewMovieDoubanVo, ReviewMovieDouban> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlReview",
        expression = "java(\"https://movie.douban.com/review/\"+reviewMovieDouban.getId())"),
    @Mapping(
        target = "createDatetime",
        source = "createDatetime",
        qualifiedByName = {"util", "unixTimestamp"}),
  })
  ReviewMovieDoubanVo to(ReviewMovieDouban reviewMovieDouban);
}
