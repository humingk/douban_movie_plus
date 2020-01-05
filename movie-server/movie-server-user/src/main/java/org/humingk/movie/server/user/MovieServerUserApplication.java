package org.humingk.movie.server.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieServerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerUserApplication.class, args);
    }

}
