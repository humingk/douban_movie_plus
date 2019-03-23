package org.humingk.movie.service.impl;

import org.humingk.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.humingk.movie.entity.Movie;
import org.humingk.movie.entity.MovieAll;
import org.humingk.movie.service.MovieService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    /**
     * 根据电影名称找出电影的所有详细资料
     *
     * @param s
     * @return
     */
    @Override
    public List<MovieAll> getMovieAllOfMovieByAlias(String s) {
        try {
            List<Movie> movies = movieMapper.selectMoviesByAlias(s);
            if (movies != null) {
                List<MovieAll> movieAlls=new ArrayList<>();
                for (Movie movie : movies) {
                    if (movie != null) {
                        Integer movieId = movie.getMovieId();
                        MovieAll movieAll = new MovieAll(movieMapper.selectMovieBaseById(movieId));
                        movieAll.setDirectors(movieMapper.selectDirectorsOfMovieById(movieId));
                        movieAll.setWriters(movieMapper.selectWritersOfMovieById(movieId));
                        movieAll.setLeadingactors(movieMapper.selectLeadingactorsOfMovieById(movieId));
                        movieAll.setTypes(movieMapper.selectTypesOfMovieById(movieId));
                        movieAll.setTags(movieMapper.selectTagsOfMovieById(movieId));
                        movieAll.setReleasetimes(movieMapper.selectReleasetimesOfMovieById(movieId));
                        movieAlls.add(movieAll);
                    }
                }
                return movieAlls;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
