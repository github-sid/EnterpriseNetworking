package com.enterprise.network.posts_service.controller;

import com.enterprise.network.posts_service.dto.PostCreateRequestDto;
import com.enterprise.network.posts_service.dto.PostDto;
import com.enterprise.network.posts_service.service.PostsService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postDto) {

        PostDto createdPostDto = postsService.createPost(postDto,1l);

        return ResponseEntity.ok(createdPostDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        PostDto postDto = postsService.getPostById(id);
        return ResponseEntity.ok(postDto);
    }


    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPostsOfUser(@PathVariable Long userId) {
        List<PostDto> postDtos = postsService.getAllPostsOfUser(userId);
        return ResponseEntity.ok(postDtos);
    }

}
