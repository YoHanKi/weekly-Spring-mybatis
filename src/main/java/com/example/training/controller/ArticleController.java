package com.example.training.controller;

import com.example.training.model.dto.AddArticleRequest;
import com.example.training.model.Article;
import com.example.training.model.dto.ArticleResponse;
import com.example.training.model.dto.ModifyArticleRequest;
import com.example.training.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {

    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article")
    @ResponseBody
    public ResponseEntity<List<ArticleResponse>> selectAllArticles() {
        List<Article> list = articleService.selectAllArticles();
        List<ArticleResponse> articleResponses = list.stream().map(x -> new ArticleResponse(x.getId(),x.getTitle(),x.getContent())).toList();
        return ResponseEntity.status(HttpStatus.OK).body(articleResponses);
    }

    @GetMapping("/article/{id}")
    public Article selectArticle(@PathVariable Long id) {
        return articleService.selectArticle(id);
    }


    @GetMapping("/api/articles")
    @ResponseBody
    public ResponseEntity<List<ArticleResponse>> showAll() {
        List<Article> list = articleService.findAll();
        List<ArticleResponse> articleResponses = list.stream().map(x -> new ArticleResponse(x.getId(), x.getTitle(), x.getContent())).toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(articleResponses);
    }
//
//    @ResponseStatus(value = HttpStatus.OK)
//    @GetMapping("/api/articles")
//    @ResponseBody
//    public List<ArticleResponse> showAll2() {
//        List<Article> list = articleService.findAll();
//        List<ArticleResponse> articleResponses = list.stream().map(x -> new ArticleResponse(x.getId(), x.getTitle(), x.getContent())).toList();
//
//        return articleResponses;
//    }
//
    @GetMapping("/api/articles/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> showOne(@PathVariable Long id) {
        Article one = articleService.findOne(id);
        return ResponseEntity.ok(one.mapping());
    }

    @PostMapping(value = "/api/articles")
    @ResponseBody
    public ResponseEntity<ArticleResponse> save(@RequestBody AddArticleRequest request) {
        Article article = request.mapper();
        int count = articleService.insertOneArticle(article);
        log.info("{}",count);
        return ResponseEntity.status(HttpStatus.CREATED).body(article.mapping());
    }

    @PutMapping(value = "/api/articles/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> modify(@PathVariable Long id,@RequestBody ModifyArticleRequest request) {
        Article article = articleService.update(id, request);
        return ResponseEntity.ok(article.mapping());
    }

    @DeleteMapping(value = "/api/article/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        articleService.deleteOneArticle(id);
    }
}