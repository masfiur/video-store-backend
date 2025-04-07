package com.movieapp.service;

import com.movieapp.model.TVShow;
import com.movieapp.repository.TVShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TVShowService {

    @Autowired
    private TVShowRepository tvShowRepository;

    // Add a new TV show
    public TVShow addTVShow(TVShow tvShow) {
        return tvShowRepository.save(tvShow);
    }

    // Get all TV shows
    public List<TVShow> getAllTVShows() {
        return tvShowRepository.findAll();
    }

    // Get a TV show by its title
    public TVShow getTVShowByTitle(String title) {
        return tvShowRepository.findByTitle(title);
    }

    // Get a TV show by its ID
    public TVShow getTVShowById(String id) {
        Optional<TVShow> tvShow = tvShowRepository.findById(id);
        return tvShow.orElse(null);
    }

    // Delete a TV show by ID
    public void deleteTVShow(String id) {
        tvShowRepository.deleteById(id);
    }
}
