package com.movieapp.controller;

import com.movieapp.model.TVShow;
import com.movieapp.service.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tvshows")
public class TVShowController {

    @Autowired
    private TVShowService tvShowService; 

    @PostMapping("/add")
    public TVShow addTVShow(@RequestBody TVShow tvShow) {
        return tvShowService.addTVShow(tvShow); 
    }

    @GetMapping("/all")
    public List<TVShow> getAllTVShows() {
        return tvShowService.getAllTVShows(); // Calling the service method to get all TV shows
    }

    // Get a TV show by its title
    @GetMapping("/title")
    public TVShow getTVShowByTitle(@RequestParam String title) {
        return tvShowService.getTVShowByTitle(title); // Calling the service method to get a TV show by title
    }

    // Get a TV show by its ID
    @GetMapping("/{id}")
    public TVShow getTVShowById(@PathVariable String id) {
        return tvShowService.getTVShowById(id); // Calling the service method to get a TV show by ID
    }

    // Delete a TV show by ID
    @DeleteMapping("/{id}")
    public void deleteTVShow(@PathVariable String id) {
        tvShowService.deleteTVShow(id); // Calling the service method to delete a TV show by ID
    }
}
