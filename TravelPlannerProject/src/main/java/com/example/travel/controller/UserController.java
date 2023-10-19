package com.example.travel.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.travel.dto.DetailsDto;
import com.example.travel.dto.LoginDto;
import com.example.travel.dto.UserDto;
import com.example.travel.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/travel")
@AllArgsConstructor
public class UserController 
{
	private UserService userService;
  
	@GetMapping("/get")
	public String welcome()
	{
		return "Welcome to Travel-Planner Web Application!!!!!";
	}
	
	//@PreAuthorize("hasRole('USER')")
	@PostMapping(value = {"/register", "/signup"})
	public ResponseEntity<String> registerNewUser(@RequestBody UserDto obj)
	{
		  userService.registerUser(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("User register Successfully");
		
	}
	
	@PostMapping(value = {"/login", "/signin"})
	public ResponseEntity<String> loginUser(@RequestBody LoginDto obj)
	{
		userService.login(obj);
		return ResponseEntity.status(HttpStatus.OK).body("User Logged-in Successfully");
	}
	
	
	@GetMapping("/fetch/{country}")
	public ResponseEntity<List<DetailsDto>> fetchDetailsByCountry(@PathVariable String country)
	{
		List<DetailsDto> detailsDto=userService.fetchDetailsByCountry(country);
		return ResponseEntity.status(HttpStatus.OK).body(detailsDto);
		
	}
}
