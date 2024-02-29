package com.cms.blog.services.impl;


import com.cms.blog.entities.CustomUserDetails;
import com.cms.blog.entities.Role;
import com.cms.blog.entities.SiteUser;
import com.cms.blog.repositories.SiteUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private SiteUserRepository siteUserRepository;

    public UserDetailsServiceImpl(SiteUserRepository siteUserRepository) {
        this.siteUserRepository = siteUserRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SiteUser siteUser = siteUserRepository.findByEmail(email);
 
        if (siteUser != null) {
            CustomUserDetails customUserDetails = new CustomUserDetails(
                siteUser.getEmail(),
                siteUser.getPassword(),
                mapRolesToAuthorities(siteUser.getRoles())
            );
            customUserDetails.setSiteUser(siteUser); 
            return customUserDetails;
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

      private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            // Pentru fiecare obiect Role, creăm un obiect SimpleGrantedAuthority și îl adăugăm în colecție
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // Returnăm colecția rezultată
        return authorities;
    }
}