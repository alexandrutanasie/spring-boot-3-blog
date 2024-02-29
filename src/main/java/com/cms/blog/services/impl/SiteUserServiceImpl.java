package com.cms.blog.services.impl;

import com.cms.blog.entities.Role;
import com.cms.blog.entities.SiteUser;
import com.cms.blog.repositories.RoleRepository;
import com.cms.blog.repositories.SiteUserRepository;
import com.cms.blog.services.SiteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SiteUserServiceImpl implements SiteUserService {

    private SiteUserRepository siteUserRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public SiteUserServiceImpl(SiteUserRepository siteUserRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.siteUserRepository = siteUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(SiteUser siteUser, String roleName) {
        //encrypt the password once we integrate spring security
        siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword()));
        Role role = roleRepository.findByName(roleName);
        if(role == null){
            role = checkRoleExist();
        }
        siteUser.setRoles(Arrays.asList(role));
        siteUserRepository.save(siteUser);
    }

    
    public void updateUser(SiteUser siteUser) {
        siteUserRepository.save(siteUser);
    }

    @Override
    public SiteUser findByEmail(String email) {
        return siteUserRepository.findByEmail(email);
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_EMPLOYEE");
        return roleRepository.save(role);
    }

    public void updateUserPassword(Long userId, String password){
        String encodedPassowrd = passwordEncoder.encode(password);

        siteUserRepository.updateUserPassword(userId, encodedPassowrd);
    }  
}