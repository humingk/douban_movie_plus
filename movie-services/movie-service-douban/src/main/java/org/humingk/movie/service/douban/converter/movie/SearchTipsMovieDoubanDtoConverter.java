package org.humingk.movie.service.douban.converter.movie;

import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.SearchTipsMovieDoubanDo;
import org.humingk.movie.service.douban.dto.movie.SearchTipsMovieDoubanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(componentModel = "spring",uses = {MovieDoubanDtoConverter.class})
public interface SearchTipsMovieDoubanDtoConverter
    extends BaseConverter<SearchTipsMovieDoubanDto, SearchTipsMovieDoubanDo> {
		@Override
		@Mappings({
						@Mapping(target = "movieDoubanDto",source = "movieDouban")
		})
		SearchTipsMovieDoubanDto to(SearchTipsMovieDoubanDo searchTipsMovieDoubanDo);
}
