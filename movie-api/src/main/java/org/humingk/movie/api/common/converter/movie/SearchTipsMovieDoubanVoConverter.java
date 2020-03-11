package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.movie.rate.RateMovieImdbVoConverter;
import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.SearchTipsMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.SearchTipsMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class, MovieDoubanVoConverter.class, RateMovieImdbVoConverter.class})
public interface SearchTipsMovieDoubanVoConverter
    extends BaseConverter<SearchTipsMovieDoubanVo, SearchTipsMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "movieDouban"),
    @Mapping(target = "rate", source = "rateMovieDouban"),
    @Mapping(
        target = "aliasList",
        source = "aliasMovieDoubanList",
        qualifiedByName = {"util", "aliasList"}),
  })
  SearchTipsMovieDoubanVo to(SearchTipsMovieDoubanDo searchTipsMovieDoubanDo);
}
