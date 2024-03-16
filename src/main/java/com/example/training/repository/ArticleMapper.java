package com.example.training.repository;

import com.example.training.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> selectAllArticles();

    Article selectArticle(Long id);

    List<Article> findAll();
    Article findOne(Long id);

    int insertOneArticle(Article article);

    int updateOneArticle(Article article);

    void deleteOneArticle(Long id);
}
