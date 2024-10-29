package com.auth.authentication.service;

import com.auth.authentication.dao.UserCredentialsDao;
import com.auth.authentication.entity.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {

    @Autowired
    private UserCredentialsDao authdao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public UserCredentials register(UserCredentials user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authdao.save(user);
    }

    public boolean verifyToken(String token) {
        jwtService.validateToken(token);
        return true;
    }

    public String generateToken(String token){
        return jwtService.generateToken(token);
    }
}
