package com.devil.springbootapplication.controllers;

import com.devil.springbootapplication.entities.Movie;
import com.devil.springbootapplication.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    //list all movies present in repo
    @RequestMapping(value = "/movies/all", method = RequestMethod.GET)
    public List<Movie> getAllMovie(){
        return movieService.getAllMovie();
    }

    //add new movie => only for admin use
    @RequestMapping(value = "/movies/add/{role}", method = RequestMethod.POST)
    public Movie addMovie(@PathVariable("role") String role, @RequestBody Movie movie){
        return movieService.addMovie(role ,movie);

    }

    //update a movie details => only for admin use
    @RequestMapping(value = "/movies/update/{role}", method = RequestMethod.PUT)
    public Movie updateMovie(@PathVariable("role") String role, @RequestBody Movie movie){
        return movieService.addMovie(role, movie);
    }

    //add new theatre location to a movie => only for admin use
    @RequestMapping(value = "/movies/addLocation/{role}", method = RequestMethod.PUT)
    public Movie addTheatreLocation(@PathVariable("role") String role, @RequestBody Movie movie){
        return movieService.addMovieLocation(role, movie);
    }

    //update theatre location to a movie => only for admin use
    @RequestMapping(value = "/movies/updateLocation/{role}", method = RequestMethod.PUT)
    public Movie updateTheatreLocation(@PathVariable("role") String role, @RequestBody Movie movie){
        return movieService.updateMovieLocation(role, movie);
    }
}