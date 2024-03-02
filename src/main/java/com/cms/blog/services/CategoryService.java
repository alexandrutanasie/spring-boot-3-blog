package com.cms.blog.services;

import java.util.List;
import java.util.Optional;

import com.cms.blog.entities.Category;

public interface CategoryService {
    List<Category> getAllCategories();

    void saveCategory(Category category);
    void deleteById(Long Id);

    Optional<Category> findById(Long Id);
    Optional<Category> findByUrl(String url);
}
