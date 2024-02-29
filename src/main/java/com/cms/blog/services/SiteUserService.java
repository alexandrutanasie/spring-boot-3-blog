package com.cms.blog.services;


import java.util.List;
import java.util.Optional;

import com.cms.blog.entities.SiteUser;

public interface SiteUserService {
    void saveUser(SiteUser siteUser, String roleName);
    void updateUser(SiteUser siteUser);
    SiteUser findByEmail(String email);
    void updateUserPassword(Long userId, String password);
}
