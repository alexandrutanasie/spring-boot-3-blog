package com.cms.blog.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    private String title;
    private String metaTitle;
    private String metaDescription;

    @Column(name = "message", columnDefinition = "TEXT", nullable = true)
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String status;

    @ManyToMany(mappedBy = "categories")
    List<Post> posts = new ArrayList<>();

}