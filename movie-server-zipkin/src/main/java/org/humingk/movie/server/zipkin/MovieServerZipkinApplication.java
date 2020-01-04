package org.humingk.movie.server.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class MovieServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerZipkinApplication.class, args);
    }

}
