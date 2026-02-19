package com.enterprise.network.posts_service.service;

import com.enterprise.network.posts_service.dto.PostCreateRequestDto;
import com.enterprise.network.posts_service.dto.PostDto;
import com.enterprise.network.posts_service.entity.Post;
import com.enterprise.network.posts_service.exception.ResourceNotFoundException;
import com.enterprise.network.posts_service.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostsService {
    
    private final PostsRepository postsRepository;
    private final ModelMapper modelMapper;
    
    public PostDto createPost(PostCreateRequestDto postDto, Long userId) {
        Post post = modelMapper.map(postDto, Post.class);
        post.setUserId(userId);
        Post savedPost = postsRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }
    
    public PostDto getPostById(Long id) {
        return postsRepository.findById(id).map(post -> modelMapper.map(post, PostDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        
    }

    public List<PostDto> getAllPostsOfUser(Long userId) {
        return postsRepository.findAllByUserId(userId).stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(java.util.stream.Collectors.toList());
    }
    

}
