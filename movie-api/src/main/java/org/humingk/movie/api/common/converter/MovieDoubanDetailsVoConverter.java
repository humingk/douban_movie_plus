package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.vo.MovieDoubanDetailsVo;
import org.humingk.movie.dal.entity.AliasMovieDouban;
import org.humingk.movie.dal.entity.MovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author humingk
 */
@Mapper(componentModel = "spring", uses = MovieDoubanVoConverter.class)
public interface MovieDoubanDetailsVoConverter {

    @Mappings({
            @Mapping(source = "movieDouban", target = "movieDoubanVo"),
            @Mapping(source = "aliasMovieDoubanList", target = "aliasList")
    })
    MovieDoubanDetailsVo to(MovieDouban movieDouban, List<AliasMovieDouban> aliasMovieDoubanList);

    default List<String> to(List<AliasMovieDouban> aliasMovieDoubanList) {
        return aliasMovieDoubanList.stream().map(AliasMovieDouban::getNameAlias).collect(Collectors.toList());
    }
}
