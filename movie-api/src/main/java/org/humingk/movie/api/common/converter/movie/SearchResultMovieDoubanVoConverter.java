package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.movie.details.CelebrityDoubanOfMovieDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.rate.RateMovieImdbVoConverter;
import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.SearchResultMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.SearchResultMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      ConverterUtil.class,
      MovieDoubanVoConverter.class,
      RateMovieImdbVoConverter.class,
      CelebrityDoubanOfMovieDoubanVoConverter.class
    })
public interface SearchResultMovieDoubanVoConverter
    extends BaseConverter<SearchResultMovieDoubanVo, SearchResultMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "movieDouban"),
    @Mapping(target = "rate", source = "rateMovieDouban"),
    @Mapping(
        target = "aliasList",
        source = "aliasMovieDoubanList",
        qualifiedByName = {"util", "aliasList"}),
    @Mapping(
        target = "typeList",
        source = "movieDoubanToTypeMovieList",
        qualifiedByName = {"util", "typeList"}),
    @Mapping(target = "celebrityList", source = "celebrityDoubanOfMovieDoubanDoList")
  })
  SearchResultMovieDoubanVo to(SearchResultMovieDoubanDo searchResultMovieDoubanDo);
}
