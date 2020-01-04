package org.humingk.movie.server.scene;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieServerSceneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerSceneApplication.class, args);
    }

}
