package org.humingk.movie.server.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/** @author humingk */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(
    basePackages = {"org.humingk.movie.dal.mapper.auto", "org.humingk.movie.dal.mapper.plus"})
public class MovieServerMusicApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieServerMusicApplication.class, args);
  }
}
