package com.cms.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cms.blog.entities.Category;
import com.cms.blog.entities.Post;
import com.cms.blog.services.CategoryService;
import com.cms.blog.services.PostService;


@Controller
public class FrontendController {

    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<Post> latestPosts = postService.findTop6ByOrderByCreatedAtDesc();
        
        model.addAttribute("title", "Homepage");
        model.addAttribute("latestPosts", latestPosts);
        model.addAttribute("categories", categories);
        return "index";
    }
}
