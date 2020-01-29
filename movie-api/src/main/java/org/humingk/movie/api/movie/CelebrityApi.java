package org.humingk.movie.api.movie;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 影人API
 *
 * @author humingk
 */
@FeignClient("movie-server-movie")
public interface CelebrityApi {

    /**
     * 获取豆瓣影人基础信息(包括影人图片)
     *
     * @param celebrityDoubanId 豆瓣影人ID
     * @return
     */
    @GetMapping("celebrity_base")
    Result celebrityBase(@RequestParam("celebrity_douban_id") long celebrityDoubanId);

    /**
     * 获取豆瓣影人基础信息列表(包括影人图片)
     *
     * @param celebrityDoubanIdList 豆瓣影人ID列表(Json字符串)
     * @return
     */
    @GetMapping("celebrity_base_list")
    Result celebrityBaseList(@RequestBody List<Long> celebrityDoubanIdList);

    /**
     * 获取豆瓣影人详细信息（包括影人图片、基础信息、参演电影基础信息（电影海报、基础信息）、影人简介）
     *
     * @param celebrityDoubanId 豆瓣影人ID
     * @return
     */
    @GetMapping("celebrity_detail")
    Result celebrityDetail(@RequestParam("celebrity_douban_id") long celebrityDoubanId);

    /**
     * 获取豆瓣影人奖项（包括电影基础信息、奖项信息）
     *
     * @param celebrityDoubanId
     * @param offset            偏移量（可选，默认0）
     * @param limit             限制数（可选，默认10）
     * @return
     */
    @GetMapping("celebrity_award")
    Result celebrityAward(@RequestParam("celebrity_douban_id") long celebrityDoubanId,
                          @RequestParam(value = "offset",
                                  required = false,
                                  defaultValue = "0") int offset,
                          @RequestParam(value = "limit",
                                  required = false,
                                  defaultValue = "10") int limit);

    /**
     * 获取豆瓣影人合作过的影人基础信息（包括影人照片、基础信息）及其相关电影基础信息（包括电影海报、基础信息）
     *
     * @param celebrityDoubanId 豆瓣影人ID
     * @param offset            合作次数偏移量（可选，默认0）
     * @param limit             合作次数限制数（可选，默认10）
     * @return
     */
    @GetMapping("celebrity_cooperator")
    Result celebrityCooperator(@RequestParam("celebrity_douban_id") long celebrityDoubanId,
                               @RequestParam(value = "offset",
                                       required = false,
                                       defaultValue = "0") int offset,
                               @RequestParam(value = "limit",
                                       required = false,
                                       defaultValue = "10") int limit);
}
