package org.humingk.movie.server.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
        "org.humingk.movie.server.user",
        "org.humingk.movie.service.user",
        "org.humingk.movie.api",
        "org.humingk.movie.common"
})
@MapperScan(basePackages = {
        "org.humingk.movie.service.common.mapper"
})
public class MovieServerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerUserApplication.class, args);
    }
}
