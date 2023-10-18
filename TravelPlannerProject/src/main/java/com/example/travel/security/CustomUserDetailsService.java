package com.example.travel.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.travel.entity.User;
import com.example.travel.exception.UserNotFoundException;
import com.example.travel.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService
{
    
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
            
		User user=userRepository.findUserByEmail(username);
		if(user==null)
		{
			throw new UserNotFoundException("User","Email",username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), null);
               
	}

}
