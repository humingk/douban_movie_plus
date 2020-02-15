package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.CelebrityDoubanOfMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.CelebrityDoubanOfMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CelebrityDoubanOfMovieDoubanVoConverter
    extends BaseConverter<CelebrityDoubanOfMovieDoubanVo, CelebrityDoubanOfMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlCelebrityDouban",
        source = "id",
        qualifiedByName = {"ConverterUtil", "getUrlCelebrityDouban"}),
    @Mapping(
        target = "idCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = {"ConverterUtil", "getIdCelebrityImdb"}),
    @Mapping(
        target = "urlCelebrityImdb",
        source = "idCelebrityImdb",
        qualifiedByName = {"ConverterUtil", "getUrlCelebrityImdb"}),
    @Mapping(target = "sex", source = "sex", qualifiedByName = "toSex"),
    @Mapping(
        target = "birthDate",
        source = "birthDate",
        qualifiedByName = {"ConverterUtil", "unixTimestampToDate"}),
    @Mapping(
        target = "urlPortrait",
        expression =
            "java(\"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p\"+celebrityDoubanOfMovieDoubanDo.getUrlPortrait()+\".webp\")"),
    @Mapping(
        target = "idProfession",
        source = "celebrityDoubanOfMovieDoubanDo.movieDoubanToCelebrityDouban.idProfession"),
    @Mapping(
        target = "profession",
        source = "celebrityDoubanOfMovieDoubanDo.movieDoubanToCelebrityDouban.idProfession",
        qualifiedByName = {"ConverterUtil", "getProfessionZh"}),
    @Mapping(
        target = "sort",
        source = "celebrityDoubanOfMovieDoubanDo.movieDoubanToCelebrityDouban.sort")
  })
  CelebrityDoubanOfMovieDoubanVo to(CelebrityDoubanOfMovieDoubanDo celebrityDoubanOfMovieDoubanDo);

  @Named("toSex")
  default String toSex(Byte sex) {
    return sex == 0 ? "女" : (sex == 1 ? "男" : "");
  }
}
