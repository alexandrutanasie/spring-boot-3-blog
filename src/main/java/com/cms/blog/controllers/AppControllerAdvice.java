package com.cms.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cms.blog.components.AppComponent;
import com.cms.blog.entities.Category;
import com.cms.blog.entities.SiteUser;
import com.cms.blog.services.CategoryService;

@ControllerAdvice
public class AppControllerAdvice {
    @Autowired
    private AppComponent appComponent;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("currentUser")
    public SiteUser getCurrentUser() {
        return appComponent.getCurrentUser();
    }
    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }
}