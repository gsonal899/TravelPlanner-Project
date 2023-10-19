package com.example.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travel.entity.Details;

public interface DetailsRepository extends JpaRepository<Details,Integer>
{
	
   public List<Details> findDetailsByCountry(String country);
   
   public Details findByWeather(String weather);
}
