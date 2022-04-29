package com.devil.springbootapplication.repository;

import com.devil.springbootapplication.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.mobile = :number")
    List<Customer> findCustomerByPhone(@Param("number") Long number);
}