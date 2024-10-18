package com.project.demo.controller;


import com.project.demo.dto.MovieDTO;
import com.project.demo.entity.Movie;
import com.project.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/getMovie")
    public List<MovieDTO> getMovies(@RequestParam Integer pageFrom, @RequestParam Integer pageTo){
        List<Movie> movies = movieService.getAllMovies(pageFrom,pageTo);
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for(Movie m:movies){
            movieDTOS.add(m.convertToMovieDTO(m));
        }
        return movieDTOS;
    }

    @GetMapping(value = "/getMovieByName/{name}")
    public List<MovieDTO> getMovieByName(@PathVariable String name){
        List<Movie> movies = movieService.findMovieByName(name);
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for(Movie m:movies){
            movieDTOS.add(m.convertToMovieDTO(m));
        }
        return movieDTOS;
    }

    @GetMapping(value = "/getMovieByGenre/{genre}")
    public List<MovieDTO> getMovieByGenre(@PathVariable String genre){
        List<Movie> movies = movieService.findMoviesByGenre(genre);
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for(Movie m:movies){
            movieDTOS.add(m.convertToMovieDTO(m));
        }
        return movieDTOS;
    }

    @GetMapping(value = "/getMovieByLanguage/{language}")
    public List<MovieDTO> getMovieByLanguage(@PathVariable String language){
        List<Movie> movies = movieService.findMoviesByLanguage(language);
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for(Movie m:movies){
            movieDTOS.add(m.convertToMovieDTO(m));
        }
        return movieDTOS;
    }

    @PostMapping(value = "/create-movie")
    public String createMovie(@RequestBody @Validated MovieDTO movieDTO){
        return movieService.createAMovie(movieDTO);
    }

}
