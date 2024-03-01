package com.cms.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findTop6ByOrderByCreatedAtDesc();
}