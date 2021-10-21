package com.librarymanagementsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Admin extends User{

	public Admin(@Value("admin") String username,@Value("1qaz2wsx") String password) {
		super(username, password);
	}
	
}
