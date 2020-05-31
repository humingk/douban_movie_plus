package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.CommentOfMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.douban.CommentOfMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CommentOfMovieDoubanVoConverter
    extends BaseConverter<CommentOfMovieDoubanVo, CommentOfMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlUserDouban",
        source = "userDouban.id",
        qualifiedByName = {"util", "urlUserDouban"}),
    @Mapping(
        target = "createDate",
        source = "createDate",
        qualifiedByName = {"util", "unixTimestamp"}),
    @Mapping(target = "nameUserDouban", source = "userDouban.nameZh")
  })
  CommentOfMovieDoubanVo to(CommentOfMovieDoubanDo commentOfMovieDoubanDo);
}
