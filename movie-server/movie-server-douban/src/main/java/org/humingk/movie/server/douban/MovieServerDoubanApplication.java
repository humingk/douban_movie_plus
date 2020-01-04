package org.humingk.movie.server.douban;

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
//@EnableFeignClients(basePackages = "org.humingk.movie.api.douban")
@ComponentScan(basePackages = {"org.humingk.movie.server.douban","org.humingk.movie.service.douban"})
@MapperScan(basePackages = "org.humingk.movie.service.common.mapper")
public class MovieServerDoubanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerDoubanApplication.class, args);
    }

}
