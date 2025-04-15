package com.chess.repository;

import com.chess.model.Comment;
import com.chess.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBlog(Blog blog);
}
