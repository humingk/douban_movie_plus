//package org.humingk.movie.server.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//
///**
// * spring webflux security 安全配置
// *
// * @author humingk
// */
//@Configuration
//@EnableWebFluxSecurity
//public class WebFluxSecurityConfig {
//    @Bean
//    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) {
//        http
//                .csrf().disable()
//                // 不需要保护的路径
//                .authorizeExchange().pathMatchers("/test1/**", "/oauth/**").permitAll()
//                // 需要保护的路径
//                .anyExchange().authenticated();
//        return http.build();
//    }
//}
