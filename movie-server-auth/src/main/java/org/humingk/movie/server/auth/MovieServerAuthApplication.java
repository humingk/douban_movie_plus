package org.humingk.movie.server.auth;

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
        "org.humingk.movie.server.auth",
        "org.humingk.movie.service.user"
})
public class MovieServerAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerAuthApplication.class, args);
    }

}
