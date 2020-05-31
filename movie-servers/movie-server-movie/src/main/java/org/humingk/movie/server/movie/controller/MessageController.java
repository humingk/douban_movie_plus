package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.about.MessageApi;
import org.humingk.movie.api.common.converter.MessageVoConverter;
import org.humingk.movie.api.common.vo.MessageResVo;
import org.humingk.movie.api.common.vo.MessageVo;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/** @author humingk */
@RestController
public class MessageController implements MessageApi {

  @Autowired private MessageService messageService;
  @Autowired private MessageVoConverter messageVoConverter;

  @Override
  public Result<MessageResVo> details(
      @RequestParam("order") @NotBlank String order,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit) {
    return Result.success(
        new MessageResVo(
            messageService.getMessageAmount(),
            messageVoConverter.toList(messageService.getMessageListOrdered(order, offset, limit))));
  }

  @Override
  public Result<Object> agree(@RequestParam("id") @NotBlank String id) {
    return messageService.agree(id) ? Result.success() : Result.error("点赞失败,请稍后再试");
  }

  @Override
  public Result<MessageVo> add(
      @RequestParam(value = "idUser", required = false, defaultValue = "") String idUser,
      @RequestParam("nickname") @NotBlank String nickname,
      @RequestParam("content") @NotBlank String content,
      @RequestHeader(value = "X-Real-IP", required = false, defaultValue = "0.0.0.0") @NotBlank
          String ip) {
    return Result.success(
        messageVoConverter.to(messageService.insertMessage(idUser, nickname, ip, content)));
  }
}
