package org.humingk.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author humingk
 */
@SpringBootApplication
@EnableZuulProxy
public class MovieServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceZuulApplication.class, args);
    }

}
