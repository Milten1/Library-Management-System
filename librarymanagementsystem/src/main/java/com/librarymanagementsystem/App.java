package com.librarymanagementsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.librarymanagementsystem.config.AppConfig;

public class App {
    public static void main( String[] args ) {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
        TUI ui = (TUI) context.getBean(TUI.class);
        ui.start();
    }
}