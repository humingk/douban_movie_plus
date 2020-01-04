package org.humingk.movie.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/fallback")
    public String fallback() {
        return "fallback";
    }
}
