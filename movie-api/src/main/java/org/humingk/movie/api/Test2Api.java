package org.humingk.movie.api;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author humingk
 */
@Validated
@FeignClient("movie-server-user")
public interface Test2Api {
    @RequestMapping(value = "/user/test2",method = RequestMethod.GET,consumes= MediaType.APPLICATION_JSON_VALUE)
    Result test2(@RequestBody @NotEmpty List<Integer> ttRR);

    @GetMapping("test3")
    Result test3(@RequestParam("t") int t);
}
