package com.fahryayii.restfulapi.service;

import com.fahryayii.restfulapi.entity.Movies;

import java.util.List;

public interface MoviesService {
    Movies saveMovies (Movies movies);
    Movies updateMovies (Movies movies);
    List<Movies> getAllMovies();
    Movies getMoviesById(String id);
    void deleteMovies(String id);
    List<Movies> saveMucMovies (List<Movies> muchMovies);
}
