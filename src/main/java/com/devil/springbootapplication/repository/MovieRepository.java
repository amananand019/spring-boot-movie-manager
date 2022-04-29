package com.devil.springbootapplication.repository;

import com.devil.springbootapplication.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m WHERE m.movieID = :movieId")
    List<Movie> findMovieByID(@Param("movieId") int movieId);
}