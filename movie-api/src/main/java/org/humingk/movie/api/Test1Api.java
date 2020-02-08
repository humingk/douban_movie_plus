package org.humingk.movie.api;

import org.humingk.movie.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author humingk
 */
@Validated
@FeignClient("movie-server-movie")
public interface Test1Api {
    @RequestMapping(value = "/movie/test1",method = RequestMethod.GET,consumes= MediaType.APPLICATION_JSON_VALUE)
    Result test1(@RequestBody @NotEmpty List<Integer> ttRR);
}
