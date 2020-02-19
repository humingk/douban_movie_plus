package org.humingk.movie.server.movie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/** @author humingk */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(
    basePackages = {
      "org.humingk.movie.server.movie",
      "org.humingk.movie.service.douban",
      "org.humingk.movie.service.imdb",
      "org.humingk.movie.service.zhihu",
      "org.humingk.movie.service.resource",
      "org.humingk.movie.api",
      "org.humingk.movie.common"
    })
@MapperScan(basePackages = {"org.humingk.movie.dal.mapper"})
public class MovieServerMovieApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieServerMovieApplication.class, args);
  }
}
