package com.movieapp.controller;


import com.movieapp.model.TVShow;
import com.movieapp.service.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/tvshows")
public class TVShowController {

    @Autowired
    private TVShowService tvShowService; 

    @PostMapping("/add")
    public TVShow addTVShow(@RequestBody TVShow tvShow) {
        return tvShowService.addTVShow(tvShow); 
    }

    @PostMapping("/add-multiple")
    public List<TVShow> addTVShow(@RequestBody List<TVShow> tvShow) {
        return tvShowService.addTVShow(tvShow);
    }

    @GetMapping("/all")
    public List<TVShow> getAllTVShows() {
        return tvShowService.getAllTVShows(); 
    }

    @GetMapping("/title")
    public TVShow getTVShowByTitle(@RequestParam String title) {
        return tvShowService.getTVShowByTitle(title);
    }

    @GetMapping("/{id}")
    public TVShow getTVShowById(@PathVariable String id) {
        return tvShowService.getTVShowById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTVShow(@PathVariable String id) {
        tvShowService.deleteTVShow(id); 
    }
}
