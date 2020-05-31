package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.celebrity.CelebrityDoubanVoConverter;
import org.humingk.movie.api.common.converter.celebrity.CelebrityImdbVoConverter;
import org.humingk.movie.api.common.vo.CelebrityVo;
import org.humingk.movie.dal.entity.CelebrityDouban;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {CelebrityDoubanVoConverter.class, CelebrityImdbVoConverter.class})
public interface CelebrityVoConverter {
  @Mappings({
    @Mapping(target = "douban", source = "celebrityDouban"),
    @Mapping(target = "imdb", source = "celebrityImdb")
  })
  CelebrityVo to(CelebrityDouban celebrityDouban, CelebrityImdb celebrityImdb);
}
