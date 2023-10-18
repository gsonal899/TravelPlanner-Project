package com.example.travel.exception;

public class UserAlreadyExistsException extends RuntimeException
{
	public UserAlreadyExistsException(String resourceName,String fieldName,String fieldValue)
	{
		super(String.format("%s already exists with given %s : '%s'", resourceName, fieldName, fieldValue));
	}
}
