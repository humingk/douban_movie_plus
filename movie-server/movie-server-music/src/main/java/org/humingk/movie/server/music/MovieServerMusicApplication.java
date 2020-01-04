package org.humingk.movie.server.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {
        "org.humingk.movie.server.music",
        "org.humingk.movie.service.douban"
})
@MapperScan(basePackages = {
        "org.humingk.movie.service.common.mapper"
})
public class MovieServerMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerMusicApplication.class, args);
    }

}
