package com.movieapp.repository;

import com.movieapp.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Repository for Movie entity
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    
    // Custom query to find a movie by title
    Movie findByTitle(String title);
}

