package com.cms.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.blog.entities.SiteUser;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    SiteUser findByEmail(String email);
}