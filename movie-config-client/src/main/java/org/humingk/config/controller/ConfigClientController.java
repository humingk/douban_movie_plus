package org.humingk.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class ConfigClientController {
    /**
     * 来自server配置属性
     */
    @Value("${profile}")
    private String profile;

    @RequestMapping("/test")
    public String test() {
        return profile;
    }
}
