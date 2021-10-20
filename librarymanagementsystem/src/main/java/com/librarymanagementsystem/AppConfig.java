package com.librarymanagementsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
