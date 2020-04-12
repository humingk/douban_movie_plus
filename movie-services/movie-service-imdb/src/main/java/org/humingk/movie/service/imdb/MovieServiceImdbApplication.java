package org.humingk.movie.service.imdb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/** @author humingk */
@SpringBootApplication
@ComponentScan(
    basePackages = {
      "org.humingk.movie.service.imdb",
      "org.humingk.movie.common",
      "org.humingk.movie.dal"
    })
@MapperScan(
    basePackages = {"org.humingk.movie.dal.mapper.auto", "org.humingk.movie.dal.mapper.plus"})
public class MovieServiceImdbApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieServiceImdbApplication.class, args);
  }
}
