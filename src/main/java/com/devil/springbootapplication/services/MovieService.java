package com.devil.springbootapplication.services;

import com.devil.springbootapplication.entities.Movie;
import com.devil.springbootapplication.entities.Theatre;
import com.devil.springbootapplication.exception.CustomAdminException;
import com.devil.springbootapplication.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    //get all movie details
    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    //add movie for admin
    public Movie addMovie(String role, Movie movie){
        if(role.equals("admin")){
            return movieRepository.save(movie);
        }else {
            throw new CustomAdminException("Admin Not Found!");
        }
    }

    //add movie theatre location for admin
    public Movie addMovieLocation(String role, Movie movie){
        if(role.equals("admin")){
            Movie movieDetail = movieRepository.findMovieByID(movie.getMovieID()).stream().findFirst().get();
            movieDetail.getTheatres().addAll(movie.getTheatres());
            movieRepository.save(movieDetail);
            return movieDetail;
        }else {
            throw new CustomAdminException("Admin Not Found!");
        }
    }

    //update movie theatre location for admin
    public Movie updateMovieLocation(String role, Movie movie){
        if(role.equals("admin")) {
            Movie movieDetail = movieRepository.findMovieByID(movie.getMovieID()).stream().findFirst().get();
            Theatre newTheatres = movie.getTheatres().stream().findFirst().get();
            Set<Theatre> theatreSet = movieDetail.getTheatres();
            for (Theatre theatre : theatreSet) {
                if (theatre.getTheatreID() == newTheatres.getTheatreID()) {
                    theatre.setTheatreName(newTheatres.getTheatreName());
                    theatre.setTheatreAddress(newTheatres.getTheatreAddress());
                    theatre.setTheatreCity(newTheatres.getTheatreCity());
                    movieRepository.save(movieDetail);
                    break;
                }
            }
            return movieDetail;
        }else{
            return null;
        }
    }
}