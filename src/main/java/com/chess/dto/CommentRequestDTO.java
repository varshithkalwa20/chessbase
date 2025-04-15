package com.chess.dto;

import lombok.Data;

@Data
public class CommentRequestDTO {
    private String content;
    private Long userId;
    private Long blogId;
    private Long parentCommentId; // optional
}
