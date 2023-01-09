package com.raven.springbootsecurityauthorizationcustomtable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*@Service
public class CustomUserService implements UserDetailsService {
    private final ICustomUserRepository customUserRepository;

    @Autowired
    public CustomUserService(ICustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String _username, _password;
        List<GrantedAuthority> _authorities;

        CustomUser customUser = this.customUserRepository.findByEmail(username);
        if (customUser != null) {
            _username = customUser.getEmail();
            _password = customUser.getPwd();
            _authorities = new ArrayList<>();
            _authorities.add(new SimpleGrantedAuthority(customUser.getRole()));
        } else {
            throw new UsernameNotFoundException("User not found with : " + username);
        }

        return new User(_username, _password, _authorities);
    }
}*/
