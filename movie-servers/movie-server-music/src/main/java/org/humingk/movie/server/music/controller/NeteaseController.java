package org.humingk.movie.server.music.controller;

import org.humingk.movie.api.music.NeteaseApi;
import org.humingk.movie.common.entity.Result;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author humingk
 */
@RestController
public class NeteaseController implements NeteaseApi {
    @Override
    public Result plays(@NotNull Long id, @Positive Integer songLimit, @Positive Integer playlistLimit, @Positive Integer playlistSongLimit, @Positive Integer albumLimit, @Positive Integer albumSongLimit) {
        return null;
    }

    @Override
    public Result hotComments(@NotNull Long id, @PositiveOrZero Integer offset, @PositiveOrZero Integer limit) {
        return null;
    }
}
