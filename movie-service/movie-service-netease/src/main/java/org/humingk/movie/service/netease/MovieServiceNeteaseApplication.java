package org.humingk.movie.service.netease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieServiceNeteaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceNeteaseApplication.class, args);
    }

}
