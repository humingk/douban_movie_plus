package org.humingk.user.controller;

import org.humingk.common.common.Result;
import org.humingk.movie.api.douban.SearchApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
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
    private SearchApi searchApi;

    @PostMapping("test_feign_api")
    public Result testFeignApi(@RequestParam("keyword") String keyword) {
        return searchApi.searchMovieTips(keyword);
    }


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


}
