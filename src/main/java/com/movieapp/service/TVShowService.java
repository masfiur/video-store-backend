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

    public TVShow addTVShow(TVShow tvShow) {
        return tvShowRepository.save(tvShow);
    }

    public List<TVShow> getAllTVShows() {
        return tvShowRepository.findAll();
    }

    public TVShow getTVShowByTitle(String title) {
        return tvShowRepository.findByTitle(title);
    }

    public TVShow getTVShowById(String id) {
        Optional<TVShow> tvShow = tvShowRepository.findById(id);
        return tvShow.orElse(null);
    }

    public void deleteTVShow(String id) {
        tvShowRepository.deleteById(id);
    }
}
