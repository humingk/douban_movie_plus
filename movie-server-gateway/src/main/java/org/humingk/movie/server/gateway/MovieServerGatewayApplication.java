package org.humingk.movie.server.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * PS: EnableEurekaClient与EnableDiscoveryClient注解在此处作用一致，用于开启服务自动注册
 *
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieServerGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServerGatewayApplication.class, args);
    }
}
