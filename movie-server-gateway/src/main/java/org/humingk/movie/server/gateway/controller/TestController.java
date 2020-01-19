package org.humingk.movie.server.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class TestController {

    @GetMapping("/test1")
    public String test() {
        return "gateway test1,nothing need";
    }

}
