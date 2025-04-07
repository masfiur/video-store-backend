package com.movieapp.repository;

import com.movieapp.model.TVShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Repository for TVShow entity
@Repository
public interface TVShowRepository extends MongoRepository<TVShow, String> {
    
    // Custom query to find a TV show by title
    TVShow findByTitle(String title);
}
