package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.travel.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>
{

    public User findUserByEmail(String email);
	
	public Boolean existsByEmail(String email);
}
