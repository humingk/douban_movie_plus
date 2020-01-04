package org.humingk.movie.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieConfigClientApplication.class, args);
    }

}
