package com.project.demo.repository;

import com.project.demo.entity.Movie;
import com.project.demo.enums.Genre;
import com.project.demo.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m where LOWER(m.movieName) LIKE LOWER(CONCAT('%',:movieName,'%') ) ")
    public List<Movie> searchByMovieNameLike(@Param(("movieName")) String movieName);

    @Query("SELECT m FROM Movie m WHERE :language MEMBER of m.movieLanguages")
    public List<Movie> searchMovieByLanguage(@Param("language")Language language);

    @Query("SELECT m FROM Movie m WHERE :genre MEMBER of m.movieGenre")
    public List<Movie> searchMovieByGenre(@Param("genre") Genre genre);

    @Query("UPDATE Movie m SET m.movieRatings = ((m.movieRatings * m.numberOfRatings + :new_rating)/m.numberOfRatings + 1), m.numberOfRatings = m.numberOfRatings + 1  WHERE m.movieId = :movie_id")
    public void updateRating(@Param("new_rating") Float newRating, @Param("movie_id") Integer movieId);
}
