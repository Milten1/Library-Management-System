package com.librarymanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.librarymanagementsystem.Admin;
import com.librarymanagementsystem.Logic;
import com.librarymanagementsystem.TUI;
import com.librarymanagementsystem.User;

//@Configuration
public class AppConfig {
	
	@Bean
	public TUI getUI() {
		return new TUI();
	}
	
	@Bean
	public Logic getLogic() {
		return new Logic();
	}
	
	@Bean
	public User getUser() {
		return new Admin("admin","1qaz2wsxa");
	}
}
