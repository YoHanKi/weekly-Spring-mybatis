package com.example.training.repository;

import com.example.training.model.dto.AddCommentRequest;
import com.example.training.model.Comment;
import com.example.training.model.dto.CommentResponse;
import com.example.training.model.dto.GetCommentRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentResponse> SelectAllComments(Long article_id);

    Comment SelectComment(GetCommentRequest response);

    void insertComment(AddCommentRequest request);
}
