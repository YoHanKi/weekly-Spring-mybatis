package com.example.training.controller;

import com.example.training.model.*;
import com.example.training.model.dto.AddCommentRequest;
import com.example.training.model.dto.AllCommentsResponse;
import com.example.training.model.dto.CommentResponse;
import com.example.training.model.dto.GetCommentRequest;
import com.example.training.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments/{articleId}")
    @ResponseBody
    public ResponseEntity<AddCommentRequest> AddComment(@PathVariable("articleId")Long article_id,
                                                        @RequestBody AddCommentRequest request) {
        commentService.AddComment(article_id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @GetMapping("/comments/{articleId}/{commentId}")
    @ResponseBody
    public ResponseEntity<CommentResponse> showComment(@PathVariable("articleId")Long article_id,
                                                       @PathVariable("commentId")Long id) {
        Comment comment = commentService.SelectComment(new GetCommentRequest(article_id,id));
        return ResponseEntity.ok(comment.toResponse());
    }

    @GetMapping("/comments/{articleId}")
    @ResponseBody
    public ResponseEntity<AllCommentsResponse> showAllComments(@PathVariable("articleId")Long article_id) {
        AllCommentsResponse response = commentService.showAllComments(article_id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
