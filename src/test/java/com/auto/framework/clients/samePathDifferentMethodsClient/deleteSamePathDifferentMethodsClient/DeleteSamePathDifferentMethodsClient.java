package com.auto.framework.clients.samePathDifferentMethodsClient.deleteSamePathDifferentMethodsClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.web.reactive.server.WebTestClient;


@Service
public class DeleteSamePathDifferentMethodsClient {
    
    @Autowired
    private WebTestClient webTestClient;


    public void deleteRequest() {
         webTestClient.delete()
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json("[]");
    }
}
