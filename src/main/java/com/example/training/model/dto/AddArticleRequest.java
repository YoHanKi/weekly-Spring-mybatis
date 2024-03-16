package com.example.training.model.dto;

import com.example.training.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

    public Article mapper() {
        Article article = new Article(title, content);
        return article;
    }
}
