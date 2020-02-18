package org.humingk.movie.server.scene;

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
      "org.humingk.movie.server.scene",
      "org.humingk.movie.service.scene",
      "org.humingk.movie.api",
      "org.humingk.movie.common"
    })
@MapperScan(basePackages = {"org.humingk.movie.dal.mapper"})
public class MovieServerSceneApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieServerSceneApplication.class, args);
  }
}
