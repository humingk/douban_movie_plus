package org.humingk.douban.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author humingk
 */
@RestController
public class SubjectController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "service douban test";
    }
}
