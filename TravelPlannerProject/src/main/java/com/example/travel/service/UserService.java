package com.example.travel.service;

import com.example.travel.dto.LoginDto;
import com.example.travel.dto.UserDto;

public interface UserService 
{
	public boolean registerUser(UserDto userDto);
	
	public boolean login(LoginDto loginDto);

}
