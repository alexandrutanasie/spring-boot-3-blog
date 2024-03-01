package com.cms.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cms.blog.entities.Category;
import com.cms.blog.services.CategoryService;

import jakarta.validation.Valid;


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

    @GetMapping("/category/add")
    public String getCategoriesAdd(Model model) {
        Category category = new Category();    

        model.addAttribute("category", category);
        return "admin/category/add";
    }

    @PostMapping("/category/save")
    public String postCategorySave(@Valid Category category, BindingResult result, Model model, RedirectAttributes redirectAttributes) {   

        if(result.hasErrors()){
            model.addAttribute("category", category);
            return "admin/category/add";
        }

        categoryService.saveCategory(category);

        return "redirect:/admin/category/list";       
    }
}
