package org.humingk.movie.api.search;

import org.humingk.movie.api.common.vo.scene.PlaceSceneVo;
import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * 场景地点搜索
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-search")
public interface SearchPlaceSceneApi {
  /**
   * 场景地点搜索提示
   *
   * @param keyword 搜索关键字
   * @param offset 偏移量（默认0）
   * @param limit 限制数（默认10）
   * @return
   * @since 2.0.0
   * @apiNote 根据地点名称开头的字符串找出场景地点的基本信息列表,,查询结果为空的将替换为模糊匹配
   */
  @RequestMapping(value = "/search/place/scene/tips", method = RequestMethod.GET)
  Result<List<PlaceSceneVo>> tips(
      @RequestParam("keyword") @NotBlank String keyword,
      @RequestParam(value = "offset", required = false, defaultValue = "0") @PositiveOrZero
          Integer offset,
      @RequestParam(value = "limit", required = false, defaultValue = "10") @PositiveOrZero
          Integer limit);
}
