package org.humingk.movie.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@RefreshScope
public class MovieConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieConfigServerApplication.class, args);
    }

}
