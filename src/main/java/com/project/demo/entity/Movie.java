package com.project.demo.entity;

import com.project.demo.enums.Genre;
import com.project.demo.enums.Language;
import com.project.demo.utility.GenreSetConverter;
import com.project.demo.utility.LanguageSetConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "movie_data")
public class Movie {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(name = "movie_name")
    @NotNull
    private String movieName;

    @Column(name = "movie_description")
    private String movieDescription;

    @Column(name = "movie_images")
    private String movieImages;

    @Column(name = "movie_ratings")
    private Double movieRatings;

    @Column(name = "number_of_ratings")
    private Integer numberOfRatings;

    @Column(name = "number_of_bookings")
    private Integer numberOfBookings;

    @Column(name = "movie_genre")
    @Convert(converter = GenreSetConverter.class)
    private Set<Genre> movieGenre;

    @Column(name = "movie_languages")
    @Convert(converter = LanguageSetConverter.class)
    private Set<Language> movieLanguages;


    @Column(name = "movie_in_threatre")
    private Boolean movieInThreatre;

    @Column(name = "movie_release_date")
    private Date movieReleaseDate;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

}
