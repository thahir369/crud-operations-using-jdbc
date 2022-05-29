package com.helloWorld.repository;

import com.helloWorld.model.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieRepository {

  List<Movie> findAllMovies();

  Optional<Movie> findMovieByName(String name);

  void addMovie(Movie movie);

  void updateMovie(Movie movie);

  void deleteMovieByName(String name);
}
