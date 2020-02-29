package org.humingk.movie.api.common.converter.celebrity;

import org.humingk.movie.api.common.converter.celebrity.details.AliasCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.celebrity.details.MovieDoubanOfCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.share.AwardOfMovieAndCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.share.ImageDoubanVoConverter;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanDetailsVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      CelebrityDoubanVoConverter.class,
      AliasCelebrityDoubanVoConverter.class,
      ImageDoubanVoConverter.class,
      MovieDoubanOfCelebrityDoubanVoConverter.class,
      AwardOfMovieAndCelebrityDoubanVoConverter.class
    })
public interface CelebrityDoubanDetailsVoConverter
    extends BaseConverter<CelebrityDoubanDetailsVo, CelebrityDoubanDetailsDto> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "celebrityDoubanDto"),
    @Mapping(target = "aliasList", source = "aliasCelebrityDoubanList"),
    @Mapping(target = "imageList", source = "imageDoubanDoList"),
    @Mapping(
        target = "movieListOrderByScore",
        source = "movieDoubanOfCelebrityDoubanDoListOrderByScore"),
    @Mapping(
        target = "movieListOrderByStartYear",
        source = "movieDoubanOfCelebrityDoubanDoListOrderByStartYear"),
    @Mapping(target = "awardList", source = "awardOfMovieAndCelebrityDoubanDoList"),
  })
  CelebrityDoubanDetailsVo to(CelebrityDoubanDetailsDto celebrityDoubanDetailsDto);
}
