package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.movie.details.UserDoubanToClassicDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.UserDoubanToClassicDouban;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface UserDoubanToClassicDoubanVoConverter
    extends BaseConverter<UserDoubanToClassicDoubanVo, UserDoubanToClassicDouban> {
  @Override
  @Mappings({
    @Mapping(
        target = "recordDatetime",
        source = "recordDatetime",
        qualifiedByName = {"util", "unixTimestamp"}),
    @Mapping(
        target = "urlUserDouban",
        source = "idUserDouban",
        qualifiedByName = {"util", "urlUserDouban"}),
  })
  UserDoubanToClassicDoubanVo to(UserDoubanToClassicDouban userDoubanToClassicDouban);
}
