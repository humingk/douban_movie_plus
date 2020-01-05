package org.humingk.movie.server.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {
        "org.humingk.movie.dal.mapper"
})
public class MovieServerAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerAuthApplication.class, args);
    }

}
