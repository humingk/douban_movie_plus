package org.humingk.movie.api.common.converter.movie.details;

import org.humingk.movie.api.common.vo.movie.details.ClassicDoubanVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.ClassicDouban;
import org.mapstruct.Mapper;

/** @author humingk */
@Mapper(componentModel = "spring")
public interface ClassicDoubanVoConverter extends BaseConverter<ClassicDoubanVo, ClassicDouban> {}
