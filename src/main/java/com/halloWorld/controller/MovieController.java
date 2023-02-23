package com.halloWorld.controller;

import com.halloWorld.entity.Movie;
import com.halloWorld.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MovieController {

  private final MovieService movieService;

  @GetMapping(value = "/allMovies", produces = "application/json")
  public List<Movie> getAllMovies() {
    return movieService.fetchAllMovies();
  }

  @GetMapping(value = "/movies", produces = "application/json")
  public List<Movie> getMoviesByYear(@RequestParam String year) {
    return movieService.fetchMoviesByYear(year);
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
