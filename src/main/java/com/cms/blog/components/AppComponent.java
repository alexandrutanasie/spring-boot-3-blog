package com.cms.blog.components;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cms.blog.entities.CustomUserDetails;
import com.cms.blog.entities.SiteUser;

@Component
@Scope("singleton")
public class AppComponent {

    public SiteUser getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        SiteUser siteUser = null;        

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
            siteUser = customUser.getSiteUser();
        }

        return siteUser;

    }
}
