package org.humingk.movie.api.common.converter.movie;

import org.humingk.movie.api.common.converter.celebrity.details.CelebrityDoubanToClassicDoubanVoConverter;
import org.humingk.movie.api.common.converter.movie.details.UserDoubanToClassicDoubanVoConverter;
import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.ClassicOfMovieDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.domain.douban.ClassicOfMovieDoubanDo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {
      ConverterUtil.class,
      UserDoubanToClassicDoubanVoConverter.class,
      CelebrityDoubanToClassicDoubanVoConverter.class
    })
public interface ClassicOfMovieDoubanVoConverter
    extends BaseConverter<ClassicOfMovieDoubanVo, ClassicOfMovieDoubanDo> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlMovieDouban",
        source = "idMovieDouban",
        qualifiedByName = {"util", "urlMovieDouban"}),
    @Mapping(target = "user", source = "userDoubanToClassicDouban"),
    @Mapping(target = "celebrity", source = "celebrityDoubanToClassicDouban"),
  })
  ClassicOfMovieDoubanVo to(ClassicOfMovieDoubanDo classicOfMovieDoubanDo);
}
