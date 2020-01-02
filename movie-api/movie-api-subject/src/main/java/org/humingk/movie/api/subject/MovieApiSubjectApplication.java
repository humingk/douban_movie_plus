package org.humingk.movie.api.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MovieApiSubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieApiSubjectApplication.class, args);
    }

}
