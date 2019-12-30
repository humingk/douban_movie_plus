package org.humingk.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author humingk
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private test t;

    /**
     * test
     *
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "(user)test,from port:" + port;
    }

    /**
     * 测试zipkin
     *
     * @return
     */
    @RequestMapping(value = "testzipkin", method = RequestMethod.GET)
    public String test2() {
        return restTemplate.getForObject("http://localhost:8080/login", String.class);
    }

    @RequestMapping(value = "testfeign", method = RequestMethod.GET)
    public String test3() {
        return t.test3();
    }

}
