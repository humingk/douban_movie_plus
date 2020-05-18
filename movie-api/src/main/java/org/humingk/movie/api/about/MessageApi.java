package org.humingk.movie.api.about;

import org.humingk.movie.api.common.vo.MessageResVo;
import org.humingk.movie.api.common.vo.MessageVo;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/**
 * 留言板
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-movie")
public interface MessageApi {

  /**
   * 留言列表
   *
   * @param order 排序方式 create_time / agree
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @since 2.0.9
   * @apiNote 根据时间或赞同数获取留言列表
   */
  @RequestMapping(value = "/movie/message/details", method = RequestMethod.GET)
  Result<MessageResVo> details(
      @RequestParam("order") @NotBlank String order,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);

  /**
   * 赞同
   *
   * @param id 留言ID
   * @return
   * @since 2.0.9
   * @apiNote 根据留言ID点赞
   */
  @RequestMapping(value = "/movie/message/agree", method = RequestMethod.PUT)
  Result<Object> agree(@RequestParam("id") @NotBlank String id);

  /**
   * 添加留言
   *
   * @param idUser 用户ID
   * @param nickname 昵称
   * @param content 留言内容
   * @param ip IP地址
   * @since 2.0.9
   * @apiNote 添加留言，至少需要“昵称”和“留言内容”两个参数
   * @return
   */
  @RequestMapping(value = "/movie/message/add", method = RequestMethod.POST)
  Result<MessageVo> add(
      @RequestParam(value = "idUser", required = false, defaultValue = "") String idUser,
      @RequestParam("nickname") @NotBlank String nickname,
      @RequestParam("content") @NotBlank String content,
      @RequestHeader(value = "X-Real-IP", required = false, defaultValue = "0.0.0.0") @NotBlank
          String ip);
}
