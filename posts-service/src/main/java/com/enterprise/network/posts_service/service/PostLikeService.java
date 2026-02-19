package com.enterprise.network.posts_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.enterprise.network.posts_service.exception.BadRequestException;
import com.enterprise.network.posts_service.exception.ResourceNotFoundException;
import com.enterprise.network.posts_service.repository.PostLikeRespository;

import com.enterprise.network.posts_service.entity.PostLike;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService {

    private final PostLikeRespository postLikeRespository;

    public void likePost(Long postId, Long userId) {
        log.info("Attempt to like post with id: {} and user id: {}", postId, userId);

        boolean exists = postLikeRespository.existsByPostId(postId);
        if (!exists) {
            throw new ResourceNotFoundException("Post not found with id: " + postId);
        }
       

        boolean alreadyLiked = postLikeRespository.existsByPostIdAndUserId(postId, userId);
        if (alreadyLiked) {
            throw new BadRequestException("Post already liked by user");
        }

        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);
        postLikeRespository.save(postLike);
    }

    public void unlikePost(Long postId, Long userId) {
        log.info("Attempt to unlike post with id: {} and user id: {}", postId, userId);

        boolean exists = postLikeRespository.existsByPostId(postId);
        if (!exists) {
            throw new ResourceNotFoundException("Post not found with id: " + postId);
        }

        boolean alreadyLiked = postLikeRespository.existsByPostIdAndUserId(postId, userId);
        if (!alreadyLiked) {
            throw new BadRequestException("Post not liked by user");
        }

        postLikeRespository.deleteByPostIdAndUserId(postId, userId);
    }





}
