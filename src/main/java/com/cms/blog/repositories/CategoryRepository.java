package com.cms.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.blog.entities.Category;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByUrl(String url);
}