package org.humingk.movie.api.common.converter.celebrity;

import org.humingk.movie.api.common.converter.celebrity.details.AliasCelebrityDoubanVoConverter;
import org.humingk.movie.api.common.vo.celebrity.SearchTipsCelebrityDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.SearchTipsCelebrityDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      CelebrityDoubanVoConverter.class,
      AliasCelebrityDoubanVoConverter.class,
    })
public interface SearchTipsCelebrityDoubanVoConverter
    extends BaseConverter<SearchTipsCelebrityDoubanVo, SearchTipsCelebrityDoubanDo> {
  @Override
  @Mappings({
    @Mapping(target = "base", source = "celebrityDouban"),
    @Mapping(target = "aliasList", source = "aliasCelebrityDoubanList")
  })
  SearchTipsCelebrityDoubanVo to(SearchTipsCelebrityDoubanDo searchTipsCelebrityDoubanDo);
}
