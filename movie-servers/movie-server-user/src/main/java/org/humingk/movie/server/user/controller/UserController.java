package org.humingk.movie.server.user.controller;

import org.humingk.movie.api.movie.SearchApi;
import org.humingk.movie.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 用户控制
 *
 * @author humingk
 */
@RestController
public class UserController {

    @Autowired
    private SearchApi searchApi;

    @GetMapping("test3")
    public Result tt() {
        return searchApi.searchMovieTips("749FD964EBD6179937E2A06A5DBB3159", 0, 10);
    }

    @GetMapping("test4")
    public Result t4() {
        return Result.success("test4");
    }

    @GetMapping("/user_info")
    public Result userInfo(Principal principal) {
        return Result.success(ResponseEntity.ok(principal));
    }

}
