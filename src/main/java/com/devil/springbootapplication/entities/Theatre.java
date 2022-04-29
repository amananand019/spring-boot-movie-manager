package com.devil.springbootapplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theatreID;
    private String theatreName;
    private String theatreAddress;
    private String theatreCity;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "theatres")
    Set<Movie> movies = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "theatreSet")
    Set<Customer> customers = new HashSet<>();

    public Theatre(){}


    public Theatre(String theatreName, String theatreAddress, String theatreCity) {
        this.theatreName = theatreName;
        this.theatreAddress = theatreAddress;
        this.theatreCity = theatreCity;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public int getTheatreID() {
        return theatreID;
    }

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public String getTheatreCity() {
        return theatreCity;
    }

    public void setTheatreCity(String theatreCity) {
        this.theatreCity = theatreCity;
    }
}