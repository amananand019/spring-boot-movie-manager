package com.devil.springbootapplication.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieID;

    private String movieName;
    private String language;
    private String genre;
    private String producer;
    private String director;
    private String description;
    private String duration;
//    private Set<String> cast;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_theatre",
            joinColumns = {@JoinColumn(name = "movieID")},
            inverseJoinColumns = {@JoinColumn(name = "theatreID")})
    private Set<Theatre> theatres = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_cast",
            joinColumns = {@JoinColumn(name = "movieID")},
            inverseJoinColumns = {@JoinColumn(name = "castId")})
    private Set<Cast> casts = new HashSet<>();

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public Set<Cast> getCasts() {
        return casts;
    }

    public void setCasts(Set<Cast> casts) {
        this.casts = casts;
    }

    public Movie(){
    }

    public Movie(String movieName, String language, String genre, String producer, String director, String description, String duration, int price) {
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
        this.producer = producer;
        this.director = director;
        this.description = description;
        this.duration = duration;
        this.price = price;
    }

    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }

    private int price;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}