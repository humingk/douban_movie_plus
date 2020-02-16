package org.humingk.movie.api.common.converter.celebrity;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.service.douban.common.dto.celebrity.CelebrityDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CelebrityDoubanVoConverter
    extends BaseConverter<CelebrityDoubanVo, CelebrityDoubanDto> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlCelebrityDouban",
        source = "id",
        qualifiedByName = {"util", "urlCelebrityDouban"}),
    @Mapping(
        target = "idCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = {"util", "idMovieImdb"}),
    @Mapping(
        target = "urlCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = {"util", "urlCelebrityImdb"}),
    @Mapping(
        target = "sex",
        source = "sex",
        qualifiedByName = {"util", "sex"}),
    @Mapping(
        target = "birthDate",
        source = "birthDate",
        qualifiedByName = {"util", "unixTimestamp"}),
    @Mapping(
        target = "urlPortrait",
        source = "urlPortrait",
        qualifiedByName = {"util", "urlPortrait"})
  })
  CelebrityDoubanVo to(CelebrityDoubanDto celebrityDoubanDto);
}
