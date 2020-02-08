package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.Test1Api;
import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author humingk
 */
@RestController
public class Test1Controller implements Test1Api {
    @Override
    public Result test1(@RequestBody List<Integer> ttRR) {
        return Result.success("test1: " + ttRR.toString());
    }
}
