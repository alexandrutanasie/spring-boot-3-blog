package com.cms.blog.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.blog.entities.Category;
import com.cms.blog.repositories.CategoryRepository;
import com.cms.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public Optional<Category> findById(Long Id){
        return categoryRepository.findById(Id);
    }

    public void deleteById(Long Id){
        categoryRepository.deleteById(Id);
    }
}
