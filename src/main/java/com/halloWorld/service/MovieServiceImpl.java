package com.halloWorld.service;

import com.halloWorld.entity.Movie;
import com.halloWorld.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

  private static final String MOVIE_WITH_NAME = "movie with name ";

  private final MovieRepository movieRepository;

  @Override
  public List<Movie> fetchAllMovies() {
    return movieRepository.findAllMovies();
  }

  @Override
  public List<Movie> fetchMoviesByYear(String year) {
    return movieRepository.findMoviesByYear(year);
  }

  @Override
  public Optional<Movie> fetchMovieByName(String name) {
    return movieRepository.findMovieByName(name);
  }

  @Override
  public String addMovie(Movie movie) {
    movieRepository.addMovie(movie);
    return MOVIE_WITH_NAME + movie.getMovieName() + " added successfully";
  }

  @Override
  public String updateMovie(Movie movie, String name) {
    // only likes can be updated
    if (movieRepository.findMovieByName(name).isPresent()) {
      movieRepository.updateMovie(movie);
      return MOVIE_WITH_NAME + movie.getMovieName() + " updated successfully";
    }
    return MOVIE_WITH_NAME + name + " not found";
  }

  @Override
  public String deleteMovieByName(String name) {
    if (movieRepository.findMovieByName(name).isPresent()) {
      movieRepository.deleteMovieByName(name);
      return MOVIE_WITH_NAME + name + " deleted successfully";
    }
    return MOVIE_WITH_NAME + name + " not found";
  }
}
