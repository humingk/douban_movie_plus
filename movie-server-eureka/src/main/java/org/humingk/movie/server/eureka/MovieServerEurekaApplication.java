package org.humingk.movie.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaServer
public class MovieServerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerEurekaApplication.class, args);
    }

}
