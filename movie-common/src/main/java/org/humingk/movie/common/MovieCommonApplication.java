package org.humingk.movie.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCommonApplication.class, args);
    }

}
