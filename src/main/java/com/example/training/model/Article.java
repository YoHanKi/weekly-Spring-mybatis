package com.example.training.model;

import com.example.training.model.dto.ArticleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;


    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public ArticleResponse mapping() {
        return new ArticleResponse(id, title, content);
    }
}
