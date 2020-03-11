package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanDetailsVoConverter;
import org.humingk.movie.api.common.converter.celebrity.CelebrityImdbDetailsVoConverter;
import org.humingk.movie.api.common.vo.CelebrityDetailsVo;
import org.humingk.movie.service.douban.dto.CelebrityDoubanDetailsDto;
import org.humingk.movie.service.imdb.dto.celebrity.CelebrityImdbDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
    componentModel = "spring",
    uses = {CelebrityDoubanDetailsVoConverter.class, CelebrityImdbDetailsVoConverter.class})
public interface CelebrityDetailsVoConverter {
  @Mappings({
    @Mapping(target = "douban", source = "celebrityDoubanDetailsDto"),
    @Mapping(target = "imdb", source = "celebrityImdbDetailsDto")
  })
  CelebrityDetailsVo to(
      CelebrityDoubanDetailsDto celebrityDoubanDetailsDto,
      CelebrityImdbDetailsDto celebrityImdbDetailsDto);
}
