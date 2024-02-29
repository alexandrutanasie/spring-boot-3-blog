package com.cms.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.blog.entities.Category;
import com.cms.blog.services.CategoryService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    
    @GetMapping("/")
    public String getDashboard() {
        return "dashboard";
    }
    
    @GetMapping("/category/list")
    public String getCategoriesList(Model model) {
        List<Category> categories = categoryService.getAllCategories();    

        model.addAttribute("categories", categories);
        return "admin/category/list";
    }
}
