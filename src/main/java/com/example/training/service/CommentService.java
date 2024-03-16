package com.example.training.service;

import com.example.training.model.*;
import com.example.training.model.dto.AddCommentRequest;
import com.example.training.model.dto.AllCommentsResponse;
import com.example.training.model.dto.CommentResponse;
import com.example.training.model.dto.GetCommentRequest;
import com.example.training.repository.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    ArticleService articleService;
    CommentMapper commentMapper;

    public CommentService(ArticleService articleService, CommentMapper commentMapper) {
        this.articleService = articleService;
        this.commentMapper = commentMapper;
    }

    public List<CommentResponse> SelectAllComments(Long article_id) {
        return commentMapper.SelectAllComments(article_id);
    }

    public Comment SelectComment(GetCommentRequest response) {
        return commentMapper.SelectComment(response);
    }

    public void AddComment(Long article_id, AddCommentRequest request) {
        request.setArticle_id(article_id);
        commentMapper.insertComment(request);
    }

    public AllCommentsResponse showAllComments(Long article_id) {
        Article article = articleService.findOne(article_id);
        List<CommentResponse> list = SelectAllComments(article_id);
        return new AllCommentsResponse(article, list);
    }
}
