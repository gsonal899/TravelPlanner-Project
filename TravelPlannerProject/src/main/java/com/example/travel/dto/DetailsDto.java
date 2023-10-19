package com.example.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailsDto 
{
	 private int serialNo;
	 private String country;
	 private String city;
	 private String weather;
	 private float maxTemperature;
	 private float minTemperature;
}
