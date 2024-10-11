package com.joinme.pojo;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@Component
public class UserData {
	
	private String username;
	
	private String password;
	
	private String role;

}
