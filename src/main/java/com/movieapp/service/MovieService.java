package com.movieapp.service;

import com.movieapp.model.Movie;
import com.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Add a new movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get a movie by its title
    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    // Get a movie by its ID
    public Movie getMovieById(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    // Delete a movie by ID
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}
