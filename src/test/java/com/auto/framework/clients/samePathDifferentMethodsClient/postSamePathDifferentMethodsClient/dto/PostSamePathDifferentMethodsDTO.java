package com.auto.framework.clients.samePathDifferentMethodsClient.postSamePathDifferentMethodsClient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSamePathDifferentMethodsDTO {
    private String name;
    private int value;
}
