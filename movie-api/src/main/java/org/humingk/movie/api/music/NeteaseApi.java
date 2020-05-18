package org.humingk.movie.api.music;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

/**
 * 音乐
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-music")
public interface NeteaseApi {}
