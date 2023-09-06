package com.fahryayii.restfulapi.controller;

import com.fahryayii.restfulapi.entity.Movies;
import com.fahryayii.restfulapi.service.MoviesService;
import com.fahryayii.restfulapi.util.constants.MessageConstant;
import com.fahryayii.restfulapi.util.customResponse.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MessageConstant.MOVIES_PATH)
public class MoviesController {

    MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {this.moviesService = moviesService;}

    @PostMapping
    public ResponseEntity<Response<Movies>> saveMovies (@RequestBody Movies movies){
        String message = "Data resource has been inserted";
        Response<Movies> response = new Response<>();
        response.setMessage(message);
        response.setData(moviesService.saveMovies(movies));
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @PutMapping
    public Movies updateMovies(@RequestBody Movies movies){ return moviesService.updateMovies(movies);}

    @GetMapping("/{id}")
    public Movies getMoviesById(@PathVariable String id){ return moviesService.getMoviesById(id);}

    @GetMapping
    public List<Movies> getAllMovies(){ return moviesService.getAllMovies();}

    @DeleteMapping("/{id}")
    public void deleteMovies(@PathVariable String id) {moviesService.deleteMovies(id);}

    @PostMapping("/save-all")
    public List<Movies> saveAllMovies(@RequestBody List<Movies> saveAllMovies) { return moviesService.saveMucMovies(saveAllMovies);}


}
