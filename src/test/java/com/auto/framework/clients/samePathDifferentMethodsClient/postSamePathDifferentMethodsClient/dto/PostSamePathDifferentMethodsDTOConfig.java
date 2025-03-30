package com.auto.framework.clients.samePathDifferentMethodsClient.postSamePathDifferentMethodsClient.dto;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class PostSamePathDifferentMethodsDTOConfig {
    
    @Autowired
    ObjectMapper objectMapper;

    @Bean
    public List<PostSamePathDifferentMethodsDTO> dataSet1() throws IOException {
        return objectMapper.readValue(
            new File("src\\test\\resources\\testdata\\api\\dataset1.json"),
            new TypeReference<>() {});
    }

    @Bean
    public List<PostSamePathDifferentMethodsDTO> dataSet2() throws IOException {
        return objectMapper.readValue(
            new File("src\\test\\resources\\testdata\\api\\dataset2.json"),
            new TypeReference<>() {});
    }
}
