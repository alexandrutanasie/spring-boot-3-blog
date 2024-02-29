package com.cms.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}