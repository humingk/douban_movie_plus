package org.humingk.movie.api.common.converter.celebrity.details;

import org.humingk.movie.api.common.vo.celebrity.details.AliasCelebrityDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.AliasCelebrityDouban;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface AliasCelebrityDoubanVoConverter
    extends BaseConverter<AliasCelebrityDoubanVo, AliasCelebrityDouban> {}
