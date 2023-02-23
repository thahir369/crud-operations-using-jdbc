package com.halloWorld.service;

import com.halloWorld.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

  List<Movie> fetchAllMovies();

  List<Movie> fetchMoviesByYear(String year);

  Optional<Movie> fetchMovieByName(String name);

  String addMovie(Movie movie);

  String updateMovie(Movie movie, String name);

  String deleteMovieByName(String name);
}
