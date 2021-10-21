package com.librarymanagementsystem;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class TUI {
	
	@Autowired
	Logic logic;
	Scanner scanner = new Scanner(System.in);
	
	public void loginScreen() {
		
		logic.startProgramLogic();
		
		while(true) {
			System.out.println("Enter username or 'exit' to end program");
			System.out.print("> ");
			
			
			String username = scanner.next();
			
			if(username.equals("exit")) break;
			
			if(logic.userExist(username)) {
				System.out.println("Enter password");
				System.out.print("> ");
				
				if(logic.passwordIsCorrect(username, scanner.next())) {
					start();
				} else System.out.println("Password incorrect");
			}else System.out.println("User does not exist");
			
		}

	}
	
	public void start() {
		
		System.out.println("Welcome to the Library Management System!");
		System.out.println("Enter your command or type 'help' to show commands: ");
		
		while(true) {
			System.out.print("> ");
			
			String command = scanner.next();
			if(command.equals("exit")) break;
			
			String[] parts = command.split(" ");
			
			switch (parts[0]) {
			case "help":{
				System.out.println("Commands: \n"
						+ "'help' - prints all commands \n"
						+ "'logout' - logouts \n"
						+ "'add' - adds a book \n"
						+ "'list' - lists all books \n"
						+ "'delete' - deletes a book \n"
						+ "'search' - searchs for a book \n"
						+ "'adduser' - adds user [ADMIN COMMAND] \n"
						+ "'deleteuser' - deletes user [ADMIN COMMAND] \n"
						+ "'exit' - ends program runtime");
				break;
			}
			case "add":{
				logic.add();
				break;
			}
			case "delete":{
				logic.delete();
				break;
			}
			case "list":{
				logic.list();
				break;
			}
			case "logout":{
				loginScreen();
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
