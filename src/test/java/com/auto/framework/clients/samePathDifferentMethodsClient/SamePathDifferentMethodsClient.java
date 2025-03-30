package com.auto.framework.clients.samePathDifferentMethodsClient;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;


@Configuration
public class SamePathDifferentMethodsClient {
    

    private static final String BASE_URL = "http://localhost:5069/api";

    @Bean
    public WebTestClient webTestClient() {
        return WebTestClient.bindToServer()
                .baseUrl(BASE_URL)
                .build();
    }

}
