package com.cms.blog.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.cms.blog.components.AppComponent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class Post {
    private AppComponent appComponent;

    public Post(AppComponent appComponent){
        this.appComponent = appComponent;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    private String title;
    private String metaTitle;
    private String metaDescription;

    @Column(name = "message", columnDefinition = "TEXT", nullable = true)
    private String content;

    private String url;

    private String status;

    @ManyToOne
    private SiteUser createdBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(name = "post_category",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categories = new ArrayList<>();


    @PrePersist
    protected void onCreate() {
        createdBy = appComponent.getCurrentUser();
    }
}
