package com.cms.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.blog.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}