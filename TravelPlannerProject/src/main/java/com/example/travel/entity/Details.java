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
@Table(name="Details")
public class Details
{
	@Column(name="Serial-No")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int serialNo;
   
   @Column(name="Country")
   private String country;
   
   @Column(name="City")
   private String city;
   
   @Column(name="Weather")
   private String weather;
   
   @Column(name="Max-Temperature[°C]")
   private float maxTemperature;
   
   @Column(name="Min-Temperature[°C]")
   private float minTemperature;
}
