package com.halloWorld.repository;

import com.halloWorld.entity.Movie;
import java.util.List;
import java.util.Optional;

public interface MovieRepository {

  List<Movie> findAllMovies();

  List<Movie> findMoviesByYear(String year);

  Optional<Movie> findMovieByName(String name);

  void addMovie(Movie movie);

  void updateMovie(Movie movie);

  void deleteMovieByName(String name);
}
