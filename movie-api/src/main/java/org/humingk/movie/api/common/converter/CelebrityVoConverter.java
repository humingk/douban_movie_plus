package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.celebrity.CelebrityImdbVoConverter;
import org.humingk.movie.api.common.vo.CelebrityVo;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDto;
import org.humingk.movie.service.imdb.dto.celebrity.CelebrityImdbDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {CelebrityDoubanVoConverter.class, CelebrityImdbVoConverter.class})
public interface CelebrityVoConverter {
  @Mappings({
    @Mapping(target = "douban", source = "celebrityDoubanDto"),
    @Mapping(target = "imdb", source = "celebrityImdbDto")
  })
  CelebrityVo to(CelebrityDoubanDto celebrityDoubanDto, CelebrityImdbDto celebrityImdbDto);
}
