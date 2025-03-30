package com.auto.framework.clients.samePathDifferentMethodsClient.getSamePathDifferentMethodsClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.web.reactive.server.WebTestClient;


@Service
public class GetSamePathDifferentMethodsClient {
    
    @Autowired
    private WebTestClient webTestClient;


    public void getRequest() {
        webTestClient.get()
                .exchange()
                .expectStatus().isOk();
    }

}
