package com.helloWorld.controller;

import com.helloWorld.model.Movie;
import com.helloWorld.service.MovieService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

  private final MovieService movieService;

  @GetMapping(value = "/movies", produces = "application/json")
  public List<Movie> getAllMovies() {
    return movieService.fetchAllMovies();
  }

  @GetMapping(value = "/movies/{movie}", produces = "application/json")
  public Optional<Movie> getMovieByName(@PathVariable String movie) {
    return movieService.fetchMovieByName(movie);
  }

  @PostMapping(value = "/movies", consumes = "application/json")
  public String addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
  }

  @PutMapping(value = "/movies/{name}", consumes = "application/json")
  public String updateMovie(@RequestBody Movie movie, @PathVariable String name) {
    // only likes can be updated
    return movieService.updateMovie(movie, name);
  }

  @DeleteMapping(value = "/movies/{name}")
  public String deleteMovieByName(@PathVariable String name) {
    return movieService.deleteMovieByName(name);
  }
}
