package org.humingk.movie.api.common.converter.movie.rate;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.rate.RateMovieImdbVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.RateImdb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface RateMovieImdbVoConverter extends BaseConverter<RateMovieImdbVo, RateImdb> {
  @Override
  @Mappings({
    @Mapping(
        target = "idMovieImdb",
        source = "id",
        qualifiedByName = {"ConverterUtil", "getIdMovieImdb"})
  })
  RateMovieImdbVo to(RateImdb rateImdb);
}
