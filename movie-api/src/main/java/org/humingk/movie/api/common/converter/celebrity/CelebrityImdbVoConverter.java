package org.humingk.movie.api.common.converter.celebrity;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.celebrity.CelebrityImdbVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.CelebrityImdb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(componentModel = "spring", uses = ConverterUtil.class)
public interface CelebrityImdbVoConverter extends BaseConverter<CelebrityImdbVo, CelebrityImdb> {
  @Override
  @Mappings({
    @Mapping(
        target = "id",
        source = "id",
        qualifiedByName = {"util", "idCelebrityImdb"})
  })
  CelebrityImdbVo to(CelebrityImdb celebrityImdb);
}
