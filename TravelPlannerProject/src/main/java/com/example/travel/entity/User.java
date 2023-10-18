package com.example.travel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="User")
public class User 
{
	   @Column(name="User-ID")
	   @Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private int userId;
	
	   @Column(name="First Name")
	   private String firstName;
	   
	   @Column(name="Last Name")
	   private String lastName;
	   
	   @Column(name="Email")
	   private String email;
	   
	   @Column(name="Password")
	   private String password;
}
