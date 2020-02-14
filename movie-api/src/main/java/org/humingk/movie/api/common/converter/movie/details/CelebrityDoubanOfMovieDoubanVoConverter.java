package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.vo.celebrity.CelebrityDoubanOfMovieDoubanVo;
import org.humingk.movie.service.douban.common.dto.celebrity.CelebrityDoubanOfMovieDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface CelebrityDoubanOfMovieDoubanVoConverter {
  @Mappings({
    @Mapping(
        target = "urlCelebrityDouban",
        expression =
            "java(\"https://movie.douban.com/celebrity/\"+celebrityDoubanOfMovieDoubanDto.getId())"),
    @Mapping(
        target = "idCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = "toIdCelebrityImdb"),
    @Mapping(
        target = "urlCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = "toUrlCelebrityImdb"),
    @Mapping(target = "sex", source = "sex", qualifiedByName = "toSex")
  })
  CelebrityDoubanOfMovieDoubanVo to(
      CelebrityDoubanOfMovieDoubanDto celebrityDoubanOfMovieDoubanDto);

  @Named("toIdCelebrityImdb")
  default String toIdCelebrityImdb(Long idCelebrityImdb) {
    return idCelebrityImdb == 0 || idCelebrityImdb == 1
        ? ""
        : "nm" + String.format("%07d", idCelebrityImdb);
  }

  @Named("toUrlCelebrityImdb")
  default String toUrlCelebrityImdb(Long idCelebrityImdb) {
    return "https://www.imdb.com/name/" + toIdCelebrityImdb(idCelebrityImdb);
  }

  @Named("toSex")
  default String toSex(Byte sex) {
    switch (sex) {
      case 0:
        return "女";
      case 1:
        return "男";
      default:
        return "";
    }
  }

  default String test(CelebrityDoubanOfMovieDoubanDto celebrityDoubanOfMovieDoubanDto) {
    return "";
  }
}
