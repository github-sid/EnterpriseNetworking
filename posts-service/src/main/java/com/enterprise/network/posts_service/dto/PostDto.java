package com.enterprise.network.posts_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    
    private Long id;
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
}
