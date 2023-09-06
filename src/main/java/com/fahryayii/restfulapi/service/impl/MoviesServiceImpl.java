package com.fahryayii.restfulapi.service.impl;

import com.fahryayii.restfulapi.entity.Movies;
import com.fahryayii.restfulapi.repository.MoviesRepository;
import com.fahryayii.restfulapi.service.MoviesService;
import com.fahryayii.restfulapi.util.constants.MessageConstant;
import com.fahryayii.restfulapi.util.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    MoviesRepository moviesRepository;

    @Autowired
    public MoviesServiceImpl(MoviesRepository moviesRepository) {this.moviesRepository = moviesRepository;}
    @Override
    public Movies saveMovies(Movies movies) {
        return moviesRepository.save(movies);
    }

    @Override
    public Movies updateMovies(Movies movies) {
        if(moviesRepository.findById(movies.getId()).isPresent()){
            return moviesRepository.save(movies);
        } else {
            throw new DataNotFoundException(MessageConstant.NOT_FOUND_PATH + movies.getId());
        }
    }

    @Override
    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Movies getMoviesById(String id) {
        return moviesRepository.findById(id).get();
    }

    @Override
    public void deleteMovies(String id) {
        moviesRepository.deleteById(id);
    }

    @Override
    public List<Movies> saveMucMovies(List<Movies> muchMovies) {
        return moviesRepository.saveAll(muchMovies);
    }
}
