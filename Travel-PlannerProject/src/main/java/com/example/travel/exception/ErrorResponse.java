package com.example.travel.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse
{
	private LocalDateTime errorTime;
	private HttpStatus errorCode;
	private  String errorMessage;
	private  String apiPath;
	
	
}
