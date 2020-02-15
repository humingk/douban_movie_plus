package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.AwardOfMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.AwardOfMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(componentModel = "spring", uses = ConverterUtil.class)
public interface AwardOfMovieDoubanVoConverter
    extends BaseConverter<AwardOfMovieDoubanVo, AwardOfMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(target = "nameZh", source = "awardOfMovieDoubanDo.awardMovie.nameZh"),
    @Mapping(
        target = "urlAward",
        expression =
            "java(\"https://movie.douban.com/awards/\"+awardOfMovieDoubanDo.getIdAwardMovie()+\"/\"+awardOfMovieDoubanDo.getAwardTh())"),
    @Mapping(
        target = "urlCelebrityDouban",
        source = "idCelebrityDouban",
        qualifiedByName = {"ConverterUtil", "getUrlCelebrityDouban"})
  })
  AwardOfMovieDoubanVo to(AwardOfMovieDoubanDo awardOfMovieDoubanDo);
}
