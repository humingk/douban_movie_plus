package org.humingk.movie.api.douban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableFeignClients
public class MovieApiDoubanApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieApiDoubanApplication.class, args);
    }
}
