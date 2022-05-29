// package com.helloWorld.repository;
//
// import com.helloWorld.model.Movie;
// import java.util.List;
// import java.util.Optional;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Primary;
// import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
// import org.springframework.stereotype.Repository;
//
// @Primary
// @Repository
// @RequiredArgsConstructor
// public class MovieRepositoryImpl2 implements MovieRepository {
//
//  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//  @Override
//  public List<Movie> findAllMovies() {
//    final MapSqlParameterSource params = new MapSqlParameterSource();
//    return namedParameterJdbcTemplate.queryForList(
//        "select * from movie ", params,Movie.class);
//  }
//
//  @Override
//  public Optional<Movie> findMovieByName(String name) {
//    final MapSqlParameterSource params = new MapSqlParameterSource();
//    params.addValue("movieName", name);
//    Movie movie = namedParameterJdbcTemplate.queryForObject("select * from movie where movieName = :movieName", params, Movie.class);
//    return Optional.ofNullable(movie);
//  }
//
//  @Override
//  public void addMovie(Movie movie) {
//    final MapSqlParameterSource params = new MapSqlParameterSource();
//    params.addValue("movieName", movie.getMovieName());
//    params.addValue("hero", movie.getHero());
//    params.addValue("release", movie.getRelease());
//    params.addValue("likes", movie.getLikes());
//    namedParameterJdbcTemplate.update(
//        "insert into movie (movieName,hero,release,likes)
// values(:movieName,:hero,:release,:likes)",
//        params);
//  }
//
//  @Override
//  public void updateMovie(Movie movie) {
//    final MapSqlParameterSource params = new MapSqlParameterSource();
//    params.addValue("movieName", movie.getMovieName());
//    params.addValue("hero", movie.getHero());
//    params.addValue("release", movie.getRelease());
//    params.addValue("likes", movie.getLikes());
//    namedParameterJdbcTemplate.update(
//        "update movie set likes = :likes where movieName = movieName", params);
//  }
//
//  @Override
//  public void deleteMovieByName(String name) {
//    final MapSqlParameterSource params = new MapSqlParameterSource();
//    params.addValue("movieName", name);
//    namedParameterJdbcTemplate.update("delete from movie where movieName = ?", params);
//  }
// }
