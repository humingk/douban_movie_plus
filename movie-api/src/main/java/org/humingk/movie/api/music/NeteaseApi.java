package org.humingk.movie.api.music;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

// 用于生成API文档
// import org.springframework.web.bind.annotation.RestController;
// @RestController

/**
 * 音乐
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-music")
public interface NeteaseApi {}
