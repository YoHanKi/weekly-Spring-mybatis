package com.example.training.model;

import com.example.training.model.dto.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long article_id;
    private String body;
    private LocalDateTime created_at;

    public Comment(Long article_id, String body) {
        this.article_id = article_id;
        this.body = body;
    }

    public CommentResponse toResponse() {
        return new CommentResponse(id, body, created_at);
    }
}
