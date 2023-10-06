package com.example.travel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableMethodSecurity
public class SecurityConfig
{
	
	@Bean
    public  static PasswordEncoder passwordEncoder()
	{
        return new BCryptPasswordEncoder();
    }
	
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	 {
	        return configuration.getAuthenticationManager();
	 }
	 
	 @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  //to enable Http Basic Authentication{username,password}
		{
			http
			     .authorizeHttpRequests((authorize)->                    
		  authorize
			        // .requestMatchers(HttpMethod.GET,"/api/message").hasRole("USER")
			        // .requestMatchers(HttpMethod.GET,"/api/message/all").hasAnyRole("USER","MANAGER","ADMIN")
			        // .requestMatchers(HttpMethod.DELETE,"/api/message").hasRole("ADMIN")
		            // .requestMatchers("travel/login/**").permitAll()
		             .requestMatchers(HttpMethod.POST,"/travel/**").hasRole("USER")
			         .anyRequest().authenticated()
			         //.exceptionHandling()
			         
			         );
			                        
			 http.httpBasic(Customizer.withDefaults());
			 http.csrf((csrf)->csrf.disable());                           // not required for stateless REST API(GET,PUT,POST.DELETE)
			                                                              //cross site request Forgery attack
			return http.build();
		}
	   
	 @Bean
	public  UserDetailsService userDetailsService()
		{
			UserDetails sonal=User.builder()
					          //.username("sonal").password("{noop}122")
					           .username("sonal").password(passwordEncoder().encode("122"))
					           .roles("USER")
					           .build();
			
			UserDetails admin=User.builder()
			                     // .username("admin").password("{noop}admin123")
			                      .username("admin").password(passwordEncoder().encode("adminpassword"))
			                      .roles("ADMIN")
			                      .build();
			
			return new InMemoryUserDetailsManager(sonal,admin);
			
		}
	    
}
