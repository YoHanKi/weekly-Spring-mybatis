package com.example.training.service;

import com.example.training.model.Article;
import com.example.training.model.dto.ModifyArticleRequest;
import com.example.training.repository.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    ArticleMapper articleMapper;

    ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public List<Article> selectAllArticles() {
        return articleMapper.selectAllArticles();
    }

    public Article selectArticle(Long id) {
        return articleMapper.selectArticle(id);
    }

    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    public Article findOne(Long id) {
        return articleMapper.findOne(id);
    }

    public int insertOneArticle(Article article) {
        return articleMapper.insertOneArticle(article);
    }

    public Article update(Long id, ModifyArticleRequest request) {
        Article article = findOne(id);
        String title = article.getTitle();
        String content = article.getContent();

        if (title.equals(request.getTitle()))
            title = request.getTitle();
        if (content.equals(request.getContent()))
            content = request.getContent();

        Article newArticle = new Article(id, title, content);
        return newArticle;
    }
    public int updateOneArticle(Article article) {
        return articleMapper.updateOneArticle(article);
    }

    public void deleteOneArticle(Long id) {
        articleMapper.deleteOneArticle(id);
    }
}
