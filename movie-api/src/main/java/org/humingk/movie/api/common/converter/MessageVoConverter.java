package org.humingk.movie.api.common.converter;

import org.humingk.movie.api.common.util.ConverterUtil;
import org.humingk.movie.api.common.vo.MessageVo;
import org.humingk.movie.common.util.BaseConverter;
import org.humingk.movie.dal.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/** @author humingk */
@Mapper(
    componentModel = "spring",
    uses = {ConverterUtil.class})
public interface MessageVoConverter extends BaseConverter<MessageVo, Message> {
  @Override
  @Mappings({
    @Mapping(
        target = "ip",
        source = "ip",
        qualifiedByName = {"util", "ip"}),
    @Mapping(
        target = "createTime",
        source = "createTime",
        qualifiedByName = {"util", "unixTimestamp2"}),
  })
  MessageVo to(Message message);
}
