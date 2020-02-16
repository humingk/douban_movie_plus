package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.CommentMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.CommentMovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CommentMovieDoubanVoConverter
    extends BaseConverter<CommentMovieDoubanVo, CommentMovieDouban> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlUserDouban",
        expression =
            "java(\"https://www.douban.com/people/\"+commentMovieDouban.getIdUserDouban())"),
    @Mapping(
        target = "createDate",
        source = "createDate",
        qualifiedByName = {"util", "unixTimestamp"})
  })
  CommentMovieDoubanVo to(CommentMovieDouban commentMovieDouban);
}
