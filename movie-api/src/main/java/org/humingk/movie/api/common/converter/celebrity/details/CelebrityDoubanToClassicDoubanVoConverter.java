package org.humingk.movie.api.common.converter.celebrity.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.celebrity.details.CelebrityDoubanToClassicDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.CelebrityDoubanToClassicDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CelebrityDoubanToClassicDoubanVoConverter
    extends BaseConverter<CelebrityDoubanToClassicDoubanVo, CelebrityDoubanToClassicDouban> {
  @Override
  @Mappings({
    @Mapping(
        target = "urlCelebrityDouban",
        source = "idCelebrityDouban",
        qualifiedByName = {"util", "urlCelebrityDouban"}),
  })
  CelebrityDoubanToClassicDoubanVo to(
      CelebrityDoubanToClassicDouban celebrityDoubanToClassicDouban);
}
