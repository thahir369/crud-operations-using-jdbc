package com.helloWorld.service;

import com.helloWorld.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieService {

  List<Movie> fetchAllMovies();

  Optional<Movie> fetchMovieByName(String name);

  String addMovie(Movie movie);

  String updateMovie(Movie movie, String name);

  String deleteMovieByName(String name);
}
