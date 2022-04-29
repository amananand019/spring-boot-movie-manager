package com.devil.springbootapplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String firstName;
    private String lastName;
    private String dob;

    @Column(unique = true)
    private long mobile;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_genres",
            joinColumns = {@JoinColumn(name = "customerId")},
            inverseJoinColumns = {@JoinColumn(name = "genre")})
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_theatre",
            joinColumns = {@JoinColumn(name = "customerId")},
            inverseJoinColumns = {@JoinColumn(name = "theatreID")})
    private Set<Theatre> theatreSet = new HashSet<>();

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Theatre> getTheatreSet() {
        return theatreSet;
    }

    public void setTheatreSet(Set<Theatre> theatreSet) {
        this.theatreSet = theatreSet;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}