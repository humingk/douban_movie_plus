package org.humingk.movie.service.impl;

import org.humingk.movie.TestBase;
import org.humingk.movie.common.MovieAll;
import org.humingk.movie.entity.*;
import org.humingk.movie.service.MovieService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MovieServiceImplTest extends TestBase {
    @Autowired
    private MovieService movieService;

    @Test
    public void getMovieAllOfMovieByAlias() {
        List<MovieAll> movieAlls = movieService.getMovieAllsOfMovieByAlias("爱丽丝");

        if (movieAlls != null) {
            for (int i = 0; i < movieAlls.size(); i++) {
                if (movieAlls.get(i) != null) {
                    System.out.println((i + 1) + ".  name        " + movieAlls.get(i).getName());
                }
            }

            for (MovieAll movieAll : movieAlls) {
                if (movieAll.getName() != null) {
                    System.out.println("======================================");
                    System.out.println("name        " + movieAll.getName());
                    System.out.println("id          " + movieAll.getMovieId());
                    System.out.println("rate        " + movieAll.getRate());
                    System.out.println("imdb        " + movieAll.getImdbId());
                    System.out.println("alias       " + movieAll.getAlias());

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
                    System.out.println("======================================");
                }
            }
        }
    }

    @Test
    public void getMovieByNameStart() {
        List<Movie> movies = movieService.getMoviesByNameStart("爱丽丝");
        if (movies != null) {
            for (Movie movie : movies) {
                if (movie.getName() != null) {
                    System.out.println("======================================");
                    System.out.println("name        " + movie.getName());
                    System.out.println("id          " + movie.getMovieId());
                    System.out.println("rate        " + movie.getRate());
                }
            }
        }
        else {

        }
    }
}