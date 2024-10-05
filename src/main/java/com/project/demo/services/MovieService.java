package com.project.demo.services;

import com.project.demo.entity.Movie;
import com.project.demo.enums.Genre;
import com.project.demo.enums.Language;
import com.project.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(Integer page, Integer size){
        Pageable numberOfMovies = PageRequest.of(page,size, Sort.by("releaseDate").ascending());
        Page<Movie> movies = movieRepository.findAll(numberOfMovies);
        return movies.getContent();
    }

    public List<Movie> findMovieByName(String movieName){
        return movieRepository.searchByMovieNameLike(movieName);
    }

    public List<Movie> findMoviesByLanguage(String language){
        Language movieLanguage = Language.valueOf(language.toUpperCase());
        return movieRepository.searchMovieByLanguage(movieLanguage);
    }
    public List<Movie> findMoviesByGenre(String genre){
        Genre movieGenre = Genre.valueOf(genre.toUpperCase());
        return movieRepository.searchMovieByGenre(movieGenre);
    }


}
