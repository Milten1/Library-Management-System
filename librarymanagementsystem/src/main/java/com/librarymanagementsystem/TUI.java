package com.librarymanagementsystem;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TUI {
	
	@Autowired
	Logic logic;
	Scanner scanner = new Scanner(System.in);
	
	public void start() {
		
		logic.startProgramLogic();
		
		while(true) {
			System.out.println("Enter username or 'exit' to end program");
			System.out.print("> ");
			
			
			String username = scanner.next();
			
			if(username.equals("exit")) break;
			
			if(logic.userExist(username)) {
				System.out.println("Enter password");
				System.out.print("> ");
				
				String password = scanner.next();
				
				if(logic.passwordIsCorrect(username, password) && !(logic.isAdmin(username))) {
					loggedAsUser();
				} else if(logic.passwordIsCorrect(username, password) && logic.isAdmin(username)) {
					loggedAsAdmin();
				} else System.out.println("Password incorrect");
			}else System.out.println("User does not exist");
			
		}

	}
	
	public void loggedAsUser() {
		System.out.println("Welcome to the Library Management System!");
		System.out.println("Enter your command or type 'help' to show commands: ");
		
		while(true) {
			System.out.print("> ");
			
			String command = scanner.next();
			if(command.equals("exit")) break;
			
			String[] parts = command.split(" ");
			
			switch (parts[0].toLowerCase()) {
			case "help":{
				System.out.println("Commands: \n"
						+ "'help' - prints all commands \n"
						+ "'logout' - logouts \n"
						+ "'add' - adds a book \n"
						+ "'list' - lists all books \n"
						+ "'delete' - deletes a book \n"
						+ "'search' - searchs for a book \n"
						+ "'exit' - ends program runtime");
				break;
			}
			case "add":{
				logic.addBook();
				break;
			}
			case "delete":{
				logic.removeBook();
				break;
			}
			case "list":{
				logic.listBooks();
				break;
			}
			case "logout":{
				start();
				break;
			}
			case "search":{
				logic.findBook();
				break;
			}
			default:{
				System.out.println("Unknown command");
				break;
			}
			}
		}
		
		logic.endProgramLogic();
	}
	
	public void loggedAsAdmin() {
		System.out.println("Welcome administrator");
		System.out.println("Enter your command or type 'help' to show commands: ");
		
		while(true) {
			System.out.print("> ");
			
			String command = scanner.next();
			if(command.equals("exit")) break;
			
			String[] parts = command.split(" ");
			
			switch (parts[0].toLowerCase()) {
			case "help":{
				System.out.println("Commands: \n"
						+ "'help' - prints all commands \n"
						+ "'logout' - logouts \n"
						+ "'list' - lists all users \n"
						+ "'add' - adds user \n"
						+ "'delet' - deletes user \n"
						+ "'exit' - ends program runtime");
				break;
			}
			case "add":{
				logic.addUser();
				break;
			}
			case "delete":{
				logic.removeUser();
				break;
			}
			case "list":{
				logic.listUsers();
				break;
			}
			case "logout":{
				start();
				break;
			}
			default:{
				System.out.println("Unknown command");
				break;
			}
			}
		}
		
		logic.endProgramLogic();
		
		
	}
	
	
	
}
