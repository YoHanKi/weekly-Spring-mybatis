package com.example.training.service;

import com.example.training.model.dto.AddCommentRequest;
import com.example.training.model.Comment;
import com.example.training.model.dto.CommentResponse;
import com.example.training.model.dto.GetCommentRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Test
    void selectAllComments() {
        List<CommentResponse> list = commentService.SelectAllComments(1L);

        for (CommentResponse comment : list) {
            log.info(comment.getId() + " : " + comment.getBody());
        }
    }

    @Test
    void selectComment() {
        Comment comment = commentService.SelectComment(new GetCommentRequest(1L,1L));
        log.info(comment.getId() + " : " + comment.getBody());
    }

    @Test
    void AddComment() {
        commentService.AddComment(1L ,new AddCommentRequest("내용추가"));
    }
}