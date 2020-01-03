package org.humingk.movie.service.gateway;

import org.humingk.movie.service.gateway.filter.MyGlobalFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * EnableDiscoveryClient与EnableDiscoveryClient注解在此处作用一致，用于开启服务自动注册
 *
 * @author humingk
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceGatewayApplication.class, args);
    }

    /**
     * 注册自定义全局过滤器
     *
     * @return
     */
    @Bean
    public MyGlobalFilter myGlobalFilter() {
        return new MyGlobalFilter();
    }

    /**
     * 注册自定义限流过滤器MyHostAddrKeyResolver
     *
     * @return
     */
    @Bean
    public MyHostAddrKeyResolver myHostAddrKeyResolver() {
        return new MyHostAddrKeyResolver();
    }
}
