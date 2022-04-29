package com.devil.springbootapplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int castId;
    private String castName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "casts")
    Set<Movie> movies = new HashSet<>();

    public Cast(){}

    public Cast(String castName) {
        this.castName = castName;
    }

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }
}