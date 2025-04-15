package com.chess.service;

import com.chess.dto.CommentRequestDTO;
import com.chess.model.Blog;
import com.chess.model.Comment;
import com.chess.model.User;
import com.chess.repository.BlogRepository;
import com.chess.repository.CommentRepository;
import com.chess.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;

    public Comment addComment(CommentRequestDTO dto) {
        System.out.println("userId = " + dto.getUserId());  // Should not be null
        System.out.println("blogId = " + dto.getBlogId());      // Should not be null

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Blog blog = blogRepository.findById(dto.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        Comment parentComment = null;
        if (dto.getParentCommentId() != null) {
            parentComment = commentRepository.findById(dto.getParentCommentId())
                    .orElseThrow(() -> new RuntimeException("Parent comment not found"));
        }

        Comment comment = Comment.builder()
                .content(dto.getContent())
                .timestamp(LocalDateTime.now())
                .user(user)
                .blog(blog)
                .parentComment(parentComment)
                .build();

        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByBlog(Long blogId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        return commentRepository.findByBlog(blog);
    }
}
