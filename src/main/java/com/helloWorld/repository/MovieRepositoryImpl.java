package com.helloWorld.repository;

import com.helloWorld.model.Movie;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Movie> findAllMovies() {

    return jdbcTemplate.query(
        "select * from movie",
        (rs, rowNum) ->
            new Movie(
                rs.getString("movieName"),
                rs.getString("hero"),
                rs.getString("release"),
                rs.getInt("likes")));
  }

  @Override
  public Optional<Movie> findMovieByName(String name) {

    return jdbcTemplate.queryForObject(
        "select * from movie where movieName = ?",
        new Object[] {name},
        (rs, rowNum) ->
            Optional.of(
                new Movie(
                    rs.getString("movieName"),
                    rs.getString("hero"),
                    rs.getString("release"),
                    rs.getInt("likes"))));
  }

  @Override
  public void addMovie(Movie movie) {
    jdbcTemplate.update(
        "insert into movie (movieName,hero,release,likes) values(?,?,?,?)",
        movie.getMovieName(),
        movie.getHero(),
        movie.getRelease(),
        movie.getLikes());
  }

  @Override
  public void updateMovie(Movie movie) {
    // only likes can be updated
    jdbcTemplate.update(
        "update movie set likes = ? where movieName = ?", movie.getLikes(), movie.getMovieName());
  }

  @Override
  public void deleteMovieByName(String name) {
    jdbcTemplate.update("delete from movie where movieName = ?", name);
  }
}
