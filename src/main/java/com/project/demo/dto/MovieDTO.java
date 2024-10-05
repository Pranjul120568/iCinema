package com.project.demo.dto;


import com.project.demo.enums.Genre;
import com.project.demo.enums.Language;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class MovieDTO {

    private Integer movieId;
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
}
