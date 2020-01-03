package org.humingk.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.humingk.movie.api.douban")
public class MovieServiceUserApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceUserApplication.class, args);
    }

}
