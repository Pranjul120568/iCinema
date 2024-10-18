package com.project.demo.dto;


import com.project.demo.entity.Movie;
import com.project.demo.enums.Genre;
import com.project.demo.enums.Language;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data

public class MovieDTO {
    @NotNull
    private Integer movieId;
    @NotNull
    private String movieName;
    private String movieDescription;
    private String movieImages;
    private Double movieRatings;
    private Integer numberOfRatings;
    private Integer numberOfBookings;
    private Set<Genre> movieGenre;
    private Set<Language> movieLanguages;
    private Boolean movieInThreatre;
    private Date movieReleaseDate;

    public Movie convertToMovieEntity(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setMovieImages(movieDTO.getMovieImages());
        movie.setMovieName(movieDTO.getMovieName());
        movie.setMovieId(movieDTO.getMovieId());
        movie.setMovieRatings(movieDTO.getMovieRatings());
        movie.setMovieDescription(movieDTO.getMovieDescription());
        movie.setMovieGenre(movieDTO.getMovieGenre());
        movie.setMovieImages(movieDTO.getMovieImages());
        movie.setMovieLanguages(movieDTO.getMovieLanguages());
        movie.setNumberOfBookings(movieDTO.getNumberOfBookings());
        movie.setNumberOfRatings(movieDTO.getNumberOfRatings());
        movie.setMovieReleaseDate(movieDTO.getMovieReleaseDate());
        return movie;
    }
}
