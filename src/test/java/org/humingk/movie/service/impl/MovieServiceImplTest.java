package org.humingk.movie.service.impl;

import org.humingk.movie.baseTest;
import org.humingk.movie.common.MovieAll;
import org.humingk.movie.entity.*;
import org.humingk.movie.service.MovieService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieServiceImplTest extends baseTest {
    @Autowired
    private MovieService movieService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getMovieAllOfMovieByAlias() {
        try {
            List<MovieAll> movieAlls = movieService.getMovieAllsOfMovieByAlias("爱心", 2, 5);
            if (movieAlls != null) {
                for (int i = 0; i < movieAlls.size(); i++) {
                    if (movieAlls.get(i) != null) {
                        logger.info((i + 1) + ".  name        " + movieAlls.get(i).getName());
                    }
                }

                for (MovieAll movieAll : movieAlls) {
                    if (movieAll.getName() != null) {
                        logger.info("======================================");
                        logger.info("name        " + movieAll.getName());
                        logger.info("id          " + movieAll.getMovieId());
                        logger.info("rate        " + movieAll.getRate());
                        logger.info("imdb        " + movieAll.getImdbId());
                        logger.info("alias       " + movieAll.getAlias());

                        List<Actor> directors = movieAll.getDirectors();
                        System.out.print("dirctors    ");
                        for (Actor director : directors) {
                            System.out.print(director.getName() + " ");
                        }
                        System.out.println();

                        List<Actor> writers = movieAll.getWriters();
                        System.out.print("writers     ");
                        for (Actor writer : writers) {
                            System.out.print(writer.getName() + " ");
                        }
                        System.out.println();

                        List<Actor> leadingactors = movieAll.getLeadingactors();
                        System.out.print("leadingactors ");
                        for (Actor leadingactor : leadingactors) {
                            System.out.print(leadingactor.getName() + " ");
                        }
                        System.out.println();

                        List<Type> types = movieAll.getTypes();
                        System.out.print("types       ");
                        for (Type type : types) {
                            System.out.print(type.getTypeName() + " ");
                        }
                        System.out.println();

                        List<Tag> tags = movieAll.getTags();
                        System.out.print("tags        ");
                        for (Tag tag : tags) {
                            System.out.print(tag.getTagName() + " ");
                        }
                        System.out.println();

                        List<Releasetime> releasetimes = movieAll.getReleasetimes();
                        System.out.print("releasetime ");
                        for (Releasetime releasetime : releasetimes) {
                            System.out.print(releasetime.getTimeArea() + " ");
                        }
                        System.out.println();
                        logger.info("======================================");
                    }
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void getMovieByNameStart() {
        List<Movie> movies = movieService.getMoviesByNameStart("爱心");
        try {
            if (movies != null) {
                for (Movie movie : movies) {
                    if (movie.getName() != null) {
                        logger.info("======================================");
                        logger.info("name        " + movie.getName());
                        logger.info("id          " + movie.getMovieId());
                        logger.info("rate        " + movie.getRate());
                    }
                }
            } else {

            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    @Test
    public void getMovieAllByMovieId() {

    }

    @Test
    public void updateRateByMovieId() {

    }

    @Test
    public void updateImdbIdByMovieId() {

    }

    @Test
    public void addMovieAll() {

    }

    @Test
    public void getAllActorsByMovieId() {
    }

    @Test
    public void getDirectorsByMovieId() {
    }

    @Test
    public void getWritersByMovieId() {
    }

    @Test
    public void getLeadingactorsByMovieId() {
    }
}