package org.humingk.movie.api.common.converter.zhihu;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.zhihu.MovieZhihuVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.MovieZhihu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MovieZhihuVoConverter extends BaseConverter<MovieZhihuVo, MovieZhihu> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        source = "idMovieDouban",
        qualifiedByName = {"util", "urlMovieDouban"}),
    @Mapping(
        target = "urlZhihuTopic",
        source = "id",
        qualifiedByName = {"util", "urlZhihuTopic"}),
  })
  MovieZhihuVo to(MovieZhihu movieZhihu);
}
