package com.auth.authentication.service;


import com.auth.authentication.dao.UserCredentialsDao;
import com.auth.authentication.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserCredentialsDao userCredentialsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional< UserCredentials> user = userCredentialsDao.findByName(username);
        System.out.println("user2: " + user.get());
        return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Username/password "));
    }
}
