package com.devil.springbootapplication.controllers;

import com.devil.springbootapplication.entities.Customer;
import com.devil.springbootapplication.requestBody.UserReqBody;
import com.devil.springbootapplication.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerServices customerServices;

    //signup user
    @RequestMapping(value = "/customer/signup", method = RequestMethod.POST)
    public Customer registerCustomer(@RequestBody Customer customer){
        return customerServices.createCustomer(customer);
    }

    //list of all customers
    @RequestMapping(value = "/customer/all", method = RequestMethod.GET)
    public List<Customer> getAllCustomer(){
        return customerServices.listCustomer();
    }

    //login customer
    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    public String loginCustomer(@RequestBody UserReqBody userReqBody){
        if(customerServices.loginCustomer(userReqBody)){
            return "Login Successful";
        }else{
            return "Login Un-Successful";
        }
    }

    //find a customer using username
    @RequestMapping(value = "/customer/{number}", method = RequestMethod.GET)
    public Customer findCustomer(@PathVariable("number") long number){
        return customerServices.findCustomerByPhone(number);
    }

    //update customer genres preferences
    @RequestMapping(value = "/customer/updateGenre", method = RequestMethod.PUT)
    public Customer updateCustomerGenre(@RequestBody Customer customer){
        return customerServices.updateCustomerPreferencesGenre(customer);
    }

    //update customer theatre location preferences
    @RequestMapping(value = "/customer/updateTheatre", method = RequestMethod.PUT)
    public Customer updateCustomerTheatre(@RequestBody Customer customer){
        return customerServices.updateCustomerPreferencesTheatre(customer);
    }
}