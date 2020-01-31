package org.humingk.movie.server.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
//@RefreshScope
public class MovieServerConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerConfigApplication.class, args);
    }

}