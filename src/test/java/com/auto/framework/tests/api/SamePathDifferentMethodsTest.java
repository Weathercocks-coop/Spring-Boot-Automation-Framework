

package com.auto.framework.tests.api;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auto.framework.clients.samePathDifferentMethodsClient.deleteSamePathDifferentMethodsClient.DeleteSamePathDifferentMethodsClient;
import com.auto.framework.clients.samePathDifferentMethodsClient.getSamePathDifferentMethodsClient.GetSamePathDifferentMethodsClient;
import com.auto.framework.clients.samePathDifferentMethodsClient.postSamePathDifferentMethodsClient.PostSamePathDifferentMethodsClient;
import com.auto.framework.clients.samePathDifferentMethodsClient.postSamePathDifferentMethodsClient.dto.PostSamePathDifferentMethodsDTO;

@SpringBootTest
class SamePathDifferentMethodsTest {

    
    @Autowired
    PostSamePathDifferentMethodsClient postSamePathDifferentMethodsClient;

    @Autowired
    GetSamePathDifferentMethodsClient getSamePathDifferentMethodsClient;

    @Autowired
    DeleteSamePathDifferentMethodsClient deleteSamePathDifferentMethodsClient;

    @Autowired
    List<PostSamePathDifferentMethodsDTO> dataSet1;

    @Test
    void testPostAndGet() {
        dataSet1.forEach(data -> {
            postSamePathDifferentMethodsClient.postRequest(data); // Execută POST request pentru fiecare element din dataset
            getSamePathDifferentMethodsClient.getRequest(); // Execută GET request
        });
    }

    @Test
    void testDelete() {

        dataSet1.forEach(data -> {
            deleteSamePathDifferentMethodsClient.deleteRequest(); // Execută DELETE request pentru fiecare element din dataset
        });
    }



}