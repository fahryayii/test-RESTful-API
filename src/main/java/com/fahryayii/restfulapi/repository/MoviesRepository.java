package com.fahryayii.restfulapi.repository;

import com.fahryayii.restfulapi.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, String> {

}
