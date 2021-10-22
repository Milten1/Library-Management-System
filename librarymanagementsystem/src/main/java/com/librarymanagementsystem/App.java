package com.librarymanagementsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.librarymanagementsystem.config.AutoConfig;

public class App {
    public static void main( String[] args ) {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(AutoConfig.class);
    	
        TUI ui = (TUI) context.getBean(TUI.class);
        ui.start();
    }
}