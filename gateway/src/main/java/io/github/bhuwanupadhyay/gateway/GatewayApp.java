package io.github.bhuwanupadhyay.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

    @RequestMapping("/hystrix-fallback")
    public String hystrixFallback() {
        return "This is a fallback";
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //@formatter:off
        return builder.routes()
                .route("inventory_route", r -> r.path("/inventory")
                        .uri("http://httpbin.org"))
                .build();
        //@formatter:on
    }

//    @Bean
//    RedisRateLimiter redisRateLimiter() {
//        return new RedisRateLimiter(1, 2);
//    }

//    @Bean
//    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
//        return http.httpBasic().and()
//                .csrf().disable()
//                .authorizeExchange()
//                .pathMatchers("/anything/**").authenticated()
//                .anyExchange().permitAll()
//                .and()
//                .build();
//    }
//
//    @Bean
//    public MapReactiveUserDetailsService reactiveUserDetailsService() {
//        UserDetails user = SecurityProperties.User.withDefaultPasswordEncoder()
//                .username("user").password("password").roles("USER")
//                .build();
//        return new MapReactiveUserDetailsService(user);
//    }


}
