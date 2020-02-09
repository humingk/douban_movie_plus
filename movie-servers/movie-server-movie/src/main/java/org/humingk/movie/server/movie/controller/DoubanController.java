package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.movie.DoubanApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

/**
 * @author humingk
 */
@RestController
public class DoubanController implements DoubanApi {
    @Autowired
    private SearchService searchService;

    @Override
    public Result bases(@NotNull Long id) {
        return null;
    }

    @Override
    public Result basesList(@NotEmpty List<Long> idList) {
        return null;
    }

    @Override
    public Result details(@NotNull Long id) {
        return null;
    }

    @Override
    public Result images(@NotNull Long id) {
        return null;
    }

    @Override
    public Result hotComments(@NotNull Long id, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
        return null;
    }

    @Override
    public Result hotReviews(Long id, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
        return null;
    }

    @Override
    public Result searchTips(@NotBlank String keyword, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
        return Result.success(searchService.getMovieDoubanListByNameStart(keyword.trim(), offset, limit));
    }

    @Override
    public Result searchDetails(@NotBlank String keyword, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
        return null;
    }
}
