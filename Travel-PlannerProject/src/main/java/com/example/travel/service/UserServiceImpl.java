package com.example.travel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.travel.dto.LoginDto;
import com.example.travel.dto.UserDto;
import com.example.travel.entity.User;
import com.example.travel.exception.UserAlreadyExistsException;
import com.example.travel.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService
{
	@Autowired  
    private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	//@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public boolean registerUser(UserDto userDto) 
	{ 
		boolean b=userRepository.existsByEmail(userDto.getEmail());
		if(b==true)
		{
			throw new UserAlreadyExistsException("User","Email",userDto.getEmail());
		}
		else
		{
		User user=new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(user);
		}

		return true;
	}

	@Override
	public boolean login(LoginDto loginDto)
	{
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getEmail(),loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return true;
	}

}
