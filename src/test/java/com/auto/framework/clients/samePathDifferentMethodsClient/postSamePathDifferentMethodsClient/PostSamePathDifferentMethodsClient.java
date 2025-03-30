package com.auto.framework.clients.samePathDifferentMethodsClient.postSamePathDifferentMethodsClient;

import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.auto.framework.clients.samePathDifferentMethodsClient.postSamePathDifferentMethodsClient.dto.PostSamePathDifferentMethodsDTO;

@Service
public class PostSamePathDifferentMethodsClient {
    

    @Autowired
    WebTestClient webTestClient;
    
    
    public void postRequest(PostSamePathDifferentMethodsDTO postSamePathDifferentMethodsClientDTO) {
        
            webTestClient.post()
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(postSamePathDifferentMethodsClientDTO)
                    .exchange()
                    .expectStatus().isCreated();
    }
}
