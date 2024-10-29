package com.auth.authentication.dao;

import com.auth.authentication.entity.UserCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserCredentialsDao extends MongoRepository<UserCredentials,Long> {
    Optional<UserCredentials> findByName(String username);
}
