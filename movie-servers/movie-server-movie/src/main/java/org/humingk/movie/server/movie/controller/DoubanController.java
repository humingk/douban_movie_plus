package org.humingk.movie.server.movie.controller;

import org.humingk.movie.api.common.converter.MovieDoubanDetailsVoConverter;
import org.humingk.movie.api.common.converter.MovieDoubanVoConverter;
import org.humingk.movie.api.common.vo.MovieDoubanDetailsVo;
import org.humingk.movie.api.common.vo.MovieDoubanVo;
import org.humingk.movie.api.movie.DoubanApi;
import org.humingk.movie.common.entity.Result;
import org.humingk.movie.service.douban.service.MovieService;
import org.humingk.movie.service.douban.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author humingk
 */
@RestController
public class DoubanController implements DoubanApi {
    @Autowired
    private MovieService movieService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private MovieDoubanVoConverter movieDoubanVoConverter;
    @Autowired
    private MovieDoubanDetailsVoConverter movieDoubanDetailsVoConverter;

    @Override
    public Result<MovieDoubanVo> bases(@NotNull Long id) {
        return Result.success(
                movieDoubanVoConverter.to(
                        movieService.getMovieDoubanByMovieDoubanId(id)
                )
        );
    }

    @Override
    public Result<MovieDoubanDetailsVo> details(@NotNull Long id) {
        return Result.success(
                movieDoubanDetailsVoConverter.to(
                        movieService.getMovieDoubanByMovieDoubanId(id),
                        movieService.getAliasMovieDoubanListByMovieDoubanId(id)
                )
        );
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
