package org.humingk.movie.api.search;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * 电影集合搜索
 *
 * @author humingk
 */
@Validated
@FeignClient(value = "movie-server-search")
public interface SearchApi {}
