package org.humingk.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author humingk
 *
 * RefreshScope:    可以使用/refresh让应用重新读取配置信息
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class MovieConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieConfigClientApplication.class, args);
    }

}
