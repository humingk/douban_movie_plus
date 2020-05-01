package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.converter.movie.MovieDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.rate.RateMovieDoubanVoConverter;
import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.RateMovieVo;
import org.humingk.movie.dal.entity.MovieDouban;
import org.humingk.movie.dal.entity.MovieZhihu;
import org.humingk.movie.dal.entity.RateImdb;
import org.humingk.movie.dal.entity.RateMovieDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class, MovieDoubanVoConverter.class, RateMovieDoubanVoConverter.class})
public interface RateMovieVoConverter {
  @Mappings({
    @Mapping(target = "bases", source = "movieDouban"),
    @Mapping(target = "doubanRate", source = "rateMovieDouban"),
    @Mapping(
        target = "idMovieImdb",
        source = "rateImdb.id",
        qualifiedByName = {"util", "idMovieImdb"}),
    @Mapping(
        target = "urlMovieImdb",
        source = "rateImdb.id",
        qualifiedByName = {"util", "urlMovieImdb"}),
    @Mapping(target = "imdbScore", source = "rateImdb.imdbScore"),
    @Mapping(target = "imdbVote", source = "rateImdb.imdbVote"),
    @Mapping(target = "tomatoScore", source = "rateImdb.tomatoScore"),
    @Mapping(target = "mtcScore", source = "rateImdb.mtcScore"),
    @Mapping(target = "idMovieZhihu", source = "movieZhihu.id"),
    @Mapping(
        target = "urlZhihuTopic",
        source = "movieZhihu.id",
        qualifiedByName = {"util", "urlZhihuTopic"}),
    @Mapping(target = "zhihuScore", source = "movieZhihu.zhihuScore"),
    @Mapping(target = "zhihuVote", source = "movieZhihu.zhihuVote"),
    @Mapping(target = "maoyanScore", source = "movieZhihu.maoyanScore"),
  })
  RateMovieVo to(
      MovieDouban movieDouban,
      RateMovieDouban rateMovieDouban,
      RateImdb rateImdb,
      MovieZhihu movieZhihu);
}
