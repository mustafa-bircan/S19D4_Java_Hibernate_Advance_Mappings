package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie);
    Movie findById(Long id);
    List<Movie> findAll();
    void delete(Movie movie);
}
