package org.humingk.movie.api.common.converter.celebrity.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.celebrity.details.MovieDoubanOfCelebrityDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.MovieDoubanOfCelebrityDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieDoubanOfCelebrityDoubanVoConverter
    extends BaseConverter<MovieDoubanOfCelebrityDoubanVo, MovieDoubanOfCelebrityDoubanDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        source = "id",
        qualifiedByName = {"util", "urlMovieDouban"}),
    @Mapping(
        target = "typeVideo",
        source = "idTypeVideo",
        qualifiedByName = {"util", "typeVideo"}),
    @Mapping(
        target = "idMovieImdb",
        source = "idMovieImdb",
        qualifiedByName = {"util", "idMovieImdb"}),
    @Mapping(
        target = "urlMovieImdb",
        source = "idMovieImdb",
        qualifiedByName = {"util", "urlMovieImdb"}),
    @Mapping(
        target = "urlPoster",
        source = "urlPoster",
        qualifiedByName = {"util", "urlPoster"}),
    @Mapping(
        target = "profession",
        source = "movieDoubanToCelebrityDouban.idProfession",
        qualifiedByName = {"util", "profession"}),
    @Mapping(target = "sort", source = "movieDoubanToCelebrityDouban.sort")
  })
  MovieDoubanOfCelebrityDoubanVo to(MovieDoubanOfCelebrityDoubanDo movieDoubanOfCelebrityDoubanDo);
}
