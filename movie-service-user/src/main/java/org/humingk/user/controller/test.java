package org.humingk.user.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "movie-service-common")
public interface test {
    @RequestMapping(value = "testfeign", method = RequestMethod.GET)
    String test3();
}
