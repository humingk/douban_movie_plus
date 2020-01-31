package org.humingk.movie.server.gateway.controller;

//import org.humingk.movie.common.entity.Result;

import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hytrix熔断处理
 *
 * @author humingk
 */
@RestController
public class FallbackController {
    /**
     * 重定向
     *
     * @return
     */
    @RequestMapping("/fallback")
    public Result fallback() {
        return Result.error("gateway fallback");
    }
}
