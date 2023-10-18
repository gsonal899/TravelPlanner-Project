package com.example.travel.exception;

public class UserNotFoundException extends RuntimeException 
{
	public UserNotFoundException(String resourceName,String fieldName,String fieldValue)
	{
		super(String.format("%s not found with given %s : '%s'", resourceName, fieldName, fieldValue));
	}
}
