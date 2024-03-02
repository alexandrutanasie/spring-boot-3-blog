package com.cms.blog.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTop6ByOrderByCreatedAtDesc();
    Optional<Post> findByUrl(String url);
}