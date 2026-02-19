package com.enterprise.network.posts_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.network.posts_service.entity.PostLike;

public interface PostLikeRespository extends JpaRepository<PostLike, Long> {

    boolean existsByPostId(Long postId);

    boolean existsByPostIdAndUserId(Long postId, Long userId);

    @Transactional
    void deleteByPostIdAndUserId(Long postId, Long userId);
}
