package com.movieapp.repository;

import com.movieapp.model.TVShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVShowRepository extends MongoRepository<TVShow, String> {
    
    TVShow findByTitle(String title);
}
