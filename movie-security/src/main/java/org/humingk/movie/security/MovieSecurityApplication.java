package org.humingk.movie.security;

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
        "org.humingk.movie.security",
        "org.humingk.movie.service.user"
})
@MapperScan(basePackages = {
        "org.humingk.movie.dal.mapper"
})
public class MovieSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSecurityApplication.class, args);
    }

}
