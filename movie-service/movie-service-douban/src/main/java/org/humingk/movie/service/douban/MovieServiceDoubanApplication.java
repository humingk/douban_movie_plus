package org.humingk.movie.service.douban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("org.humingk.common.mapper")
public class MovieServiceDoubanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceDoubanApplication.class, args);
    }

}
