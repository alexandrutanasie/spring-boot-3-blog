package com.cms.blog.services;

import java.util.List;
import java.util.Optional;

import com.cms.blog.entities.Post;

public interface PostService {
    List<Post> getAllPosts();
    Optional<Post> findById(Long Id);
    void savePost(Post post);
    void deleteById(Long Id);
}
