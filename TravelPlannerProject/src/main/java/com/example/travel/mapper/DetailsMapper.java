package com.example.travel.mapper;


import com.example.travel.dto.DetailsDto;
import com.example.travel.entity.Details;

public class DetailsMapper 
{
   public static Details mapToDetails(DetailsDto detailsDto)
   {
	   Details details=new Details(
			   detailsDto.getSerialNo(),
			   detailsDto.getCountry(),
			   detailsDto.getCity(),
			   detailsDto.getWeather(),
			   detailsDto.getMaxTemperature(),
			   detailsDto.getMinTemperature()
			  
			   
	          );
	return details;
	   
   }
   
   public static DetailsDto mapToDetailsDto(Details details)
   {
	   DetailsDto detailsDto=new DetailsDto(
			   details.getSerialNo(),
			   details.getCountry(),
			   details.getCity(),
			   details.getWeather(),
			   details.getMaxTemperature(),
			   details.getMinTemperature()
			   
			  
			   );
	return detailsDto;
	   
   }
}
