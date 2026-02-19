package com.enterprise.network.posts_service.repository;

import com.enterprise.network.posts_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {
    
    List<Post> findByUserId(Long userId);
    
    @Query("SELECT p FROM Post p WHERE p.userId = :userId ORDER BY p.createdAt DESC")
    List<Post> findByUserIdOrderByCreatedAtDesc(@Param("userId") Long userId);
    
    @Query("SELECT COUNT(p) FROM Post p WHERE p.userId = :userId")
    long countByUserId(@Param("userId") Long userId);

    List<Post> findAllByUserId(Long userId);
}
