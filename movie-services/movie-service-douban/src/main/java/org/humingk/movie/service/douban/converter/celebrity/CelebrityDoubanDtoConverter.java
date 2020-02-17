package org.humingk.movie.service.douban.converter.celebrity;

import ch.qos.logback.core.pattern.ConverterUtil;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.CelebrityDouban;
import org.humingk.movie.service.douban.dto.celebrity.CelebrityDoubanDto;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface CelebrityDoubanDtoConverter
    extends BaseConverter<CelebrityDoubanDto, CelebrityDouban> {}
