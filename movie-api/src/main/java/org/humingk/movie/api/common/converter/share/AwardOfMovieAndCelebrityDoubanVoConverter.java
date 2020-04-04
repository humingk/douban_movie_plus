package org.humingk.movie.api.common.converter.share;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.share.AwardOfMovieAndCelebrityDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.douban.AwardOfMovieAndCelebrityDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(componentModel = "spring", uses = ConverterUtil.class)
public interface AwardOfMovieAndCelebrityDoubanVoConverter
    extends BaseConverter<AwardOfMovieAndCelebrityDoubanVo, AwardOfMovieAndCelebrityDoubanDo> {
  @Override
  @Mappings({
    @Mapping(target = "nameZh", source = "awardMovie.nameZh"),
    @Mapping(
        target = "urlAward",
        expression =
            "java(\"https://movie.douban.com/awards/\"+awardOfMovieAndCelebrityDoubanDo.getIdAwardMovie()+\"/\"+awardOfMovieAndCelebrityDoubanDo.getAwardTh())"),
    @Mapping(
        target = "urlCelebrityDouban",
        source = "idCelebrityDouban",
        qualifiedByName = {"util", "urlCelebrityDouban"})
  })
  AwardOfMovieAndCelebrityDoubanVo to(
      AwardOfMovieAndCelebrityDoubanDo awardOfMovieAndCelebrityDoubanDo);
}
