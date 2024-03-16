package com.example.training.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentRequest {

    private Long article_id;
    private String body;

    public AddCommentRequest(String body) {
        this.body = body;
    }

}
