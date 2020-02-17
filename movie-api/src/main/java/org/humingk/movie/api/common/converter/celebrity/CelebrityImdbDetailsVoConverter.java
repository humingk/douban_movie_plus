package org.humingk.movie.api.common.converter.celebrity;

import org.humingk.movie.api.common.converter.celebrity.details.MovieImdbOfCelebrityImdbVoConverter;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbDetailsVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.imdb.dto.celebrity.CelebrityImdbDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {CelebrityImdbVoConverter.class, MovieImdbOfCelebrityImdbVoConverter.class})
public interface CelebrityImdbDetailsVoConverter
    extends BaseConverter<CelebrityImdbDetailsVo, CelebrityImdbDetailsDto> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "celebrityImdbDto"),
    @Mapping(target = "movieList", source = "movieImdbOfCelebrityImdbDoList"),
  })
  CelebrityImdbDetailsVo to(CelebrityImdbDetailsDto celebrityImdbDetailsDto);
}
