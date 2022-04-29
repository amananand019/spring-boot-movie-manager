package com.devil.springbootapplication;

import com.devil.springbootapplication.entities.Cast;
import com.devil.springbootapplication.entities.Customer;
import com.devil.springbootapplication.entities.Movie;
import com.devil.springbootapplication.entities.Theatre;
import com.devil.springbootapplication.requestBody.UserReqBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ApplicationTests {


	//Get all movies
	@Test
	public void testGetAllMovie(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Movie[]> response = restTemplate.getForEntity("http://localhost:8080/movies/all", Movie[].class);
		Assertions.assertNotNull(response.getBody());
	}

	//Get all customers
	@Test
	public void testGetAllCustomer(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer[]> response = restTemplate.getForEntity("http://localhost:8080/customer/all", Customer[].class);
		Assertions.assertNotNull(response.getBody());
	}

	//Get customer using username i.e phone number
	@Test
	public void testGetCustomerByUsername(){
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject("http://localhost:8080/customer/9122505091", Customer.class);
		Assertions.assertNotNull(customer);
	}

	//Customer Signup
	@Test
	public void testCustomerSignUp(){
		Customer customer = new Customer();
		customer.setFirstName("Devil");
		customer.setLastName("Prince");
		customer.setEmail("devilprince@gmail.com");
		customer.setDob("01-01-1995");
		customer.setMobile(Long.parseLong("1234567890"));

		RestTemplate restTemplate = new RestTemplate();
		Customer customer1 = restTemplate.postForObject("http://localhost:8080/customer/signup", customer, Customer.class);
		Assertions.assertNotNull(customer1);
	}

	//Customer Login
	@Test
	public void testCustomerLogin(){
		UserReqBody userReqBody = new UserReqBody();
		userReqBody.setMobileNumber(Long.parseLong("9122505091"));
		userReqBody.setPassword("05012000");

		RestTemplate restTemplate = new RestTemplate();
		String str = restTemplate.postForObject("http://localhost:8080/customer/login", userReqBody, String.class);
		Assertions.assertEquals("Login Successful", str);
	}

	//Add Movie
	@Test
	public void testAddMovieAdmin(){
		Movie movie = new Movie("Kabir Singh",
				"Hindi", "Romance", "abc",
				"xyz", "It's a love story", "2 hours", 200);

		Theatre theatre = new Theatre("Rambhawan", "MG Road", "Bangalore");
		movie.getTheatres().add(theatre);
		theatre.getMovies().add(movie);
		Cast cast1 = new Cast("Shahid Kapoor");
		Cast cast2 = new Cast("Kiara Advani");
		movie.getCasts().add(cast1);
		movie.getCasts().add(cast2);

		RestTemplate restTemplate = new RestTemplate();
		Movie movie1 = restTemplate.postForObject("http://localhost:8080/movies/add/admin", movie, Movie.class);
		Assertions.assertNotNull(movie1);
	}
}
