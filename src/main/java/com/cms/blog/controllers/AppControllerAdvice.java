package com.cms.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cms.blog.components.AppComponent;
import com.cms.blog.entities.SiteUser;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AppControllerAdvice {
    @Autowired
    private AppComponent appComponent;

    @ModelAttribute("currentUser")
    public SiteUser getCurrentUser() {
        return appComponent.getCurrentUser();
    }
}