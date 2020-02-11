package org.humingk.movie.server.gateway.controller;

import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * 网关转发异常
 *
 * @author humingk
 */
public class FallbackController {
    /**
     * Hytrix熔断处理
     *
     * @return
     */
    @RequestMapping("/fallback")
    public Result fallback() {
        return Result.error("gateway fallback");
    }
}
