package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.movie.ZhihuApi;
import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author humingk
 */
@RestController
public class ZhihuController implements ZhihuApi {
    @Override
    public Result questions(@NotNull Long id, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
        return null;
    }
}
