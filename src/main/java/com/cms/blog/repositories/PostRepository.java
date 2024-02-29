package com.cms.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}