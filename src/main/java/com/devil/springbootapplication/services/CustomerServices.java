package com.devil.springbootapplication.services;

import com.devil.springbootapplication.entities.Customer;
import com.devil.springbootapplication.repository.CustomerRepository;
import com.devil.springbootapplication.requestBody.UserReqBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    CustomerRepository customerRepository;

    // signup new customer
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    // returns list of all customers
    public List<Customer> listCustomer(){
        return customerRepository.findAll();
    }

    // login customers
    public boolean loginCustomer(UserReqBody userReqBody){
//        Customer customer = customerRepository.findAll().stream().filter(t -> t.getMobile() == userReqBody.getMobileNumber()).findFirst().get();
//        System.out.println(customer.getMobile() +" : "+  customer.getDob());
//        String[] passwordArray = customer.getDob().trim().split("-");

        String[] dob = customerRepository
                .findCustomerByPhone(userReqBody.getMobileNumber())
                .stream().findFirst().get()
                .getDob().split("-");
        StringBuilder password = new StringBuilder();
        for(String arr: dob){
            password.append(arr);
        }

        System.out.println("password: " + password);
        return password.toString().equals(userReqBody.getPassword());
    }

    // finds customer with username i.e., phone number
    public Customer findCustomerByPhone(long number){
        return customerRepository.findCustomerByPhone(number).stream().findFirst().get();
    }

    // update customer genre preferences
    public Customer updateCustomerPreferencesGenre(Customer customer){
        Customer customerDetail = customerRepository.findCustomerByPhone(customer.getMobile()).stream().findFirst().get();
        customerDetail.getGenres().clear();
        customerDetail.getGenres().addAll(customer.getGenres());
        customerRepository.save(customerDetail);
        return customerDetail;
    }

    // update customer theatre preferences
    public Customer updateCustomerPreferencesTheatre(Customer customer){
        Customer customerDetail = customerRepository.findCustomerByPhone(customer.getMobile()).stream().findFirst().get();
        customerDetail.getTheatreSet().clear();
        customerDetail.getTheatreSet().addAll(customer.getTheatreSet());
        customerRepository.save(customerDetail);
        return customerDetail;
    }
}