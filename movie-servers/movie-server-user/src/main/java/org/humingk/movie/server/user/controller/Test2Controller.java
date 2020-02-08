package org.humingk.movie.server.user.controller;

import org.humingk.movie.api.Test1Api;
import org.humingk.movie.api.Test2Api;
import org.humingk.movie.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author humingk
 */
@RestController
public class Test2Controller implements Test2Api {

    @Autowired
    private Test1Api test1Api;

    @Override
    public Result test2(@RequestBody List<Integer> ttRR) {
        return test1Api.test1(ttRR);
    }

    @Override
    public Result test3(int t) {
        return null;
    }
}
