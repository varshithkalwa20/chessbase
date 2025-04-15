package com.chess.controller;

import com.chess.dto.CommentRequestDTO;
import com.chess.model.Comment;
import com.chess.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // Create a comment
    @PostMapping
    public Comment addComment(@RequestBody CommentRequestDTO dto) {
        return commentService.addComment(dto);
    }

    // Get all comments for a blog
    @GetMapping("/blog/{blogId}")
    public List<Comment> getCommentsForBlog(@PathVariable Long blogId) {
        return commentService.getCommentsByBlog(blogId);
    }
}
