package org.humingk.movie.mapper;

import org.humingk.movie.baseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieMapperTest extends baseTest {
    @Autowired
    private MovieMapper movieMapper;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Test
    public void updateRateByPrimaryKey() {
        int movieId=1291546;
        float rate= 9.6f;
        movieMapper.updateRateByPrimaryKey(movieId,rate);
    }

    @Test
    public void updateImdbIdByPrimaryKey() {
        int movieId=1291546;
        String imdbId="tt0106332";
        movieMapper.updateImdbIdByPrimaryKey(movieId,imdbId);
    }

    @Test
    public void updateMovieBaseByMovieAll() {
    }

    @Test
    public void selectMoviesByAlias() {
    }

    @Test
    public void selectMoviesByNameStart() {
    }

    @Test
    public void selectMovieBaseById() {
    }

    @Test
    public void selectMoviesByDirectorId() {
    }

    @Test
    public void selectMoviesByWriterId() {
    }

    @Test
    public void selectMoviesByLeadingactorId() {
    }
}