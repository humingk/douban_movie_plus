package org.humingk.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
@RefreshScope
public class ConfigClientController {
    /**
     * 来自config server从git获取的配置属性
     */
    @Value("${profile}")
    private String profile;

    @RequestMapping("/test")
    public String test() {
        return profile;
    }
}
