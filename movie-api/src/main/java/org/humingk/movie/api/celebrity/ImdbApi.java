package org.humingk.movie.api.celebrity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

// 用于生成API文档
//import org.springframework.web.bind.annotation.RestController;
//@RestController

/**
 * IMDB影人API
 *
 * @author humingk
 */
@Validated
@FeignClient("movie-server-celebrity")
public interface ImdbApi {

}
