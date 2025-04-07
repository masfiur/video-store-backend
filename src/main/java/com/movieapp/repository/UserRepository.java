package com.movieapp.repository;

import com.movieapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Repository for User entity
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
    // Custom query to find a user by email
    User findByEmail(String email);
}
