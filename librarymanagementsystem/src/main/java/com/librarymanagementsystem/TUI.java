package com.librarymanagementsystem;

import java.util.Scanner;

public class TUI {
	public void start() {
		System.out.println("Welcome to the Library Management System!");
		System.out.println("Enter your command or type 'help' to show commands: ");
		System.out.print("> ");
		
		Scanner scanner = new Scanner(System.in);
		String command = scanner.next();
		
		String[] parts = command.split(" ");
		
		switch (parts[0]) {
		case "help":{
			System.out.println("Commands: \n"
					+ "'help' - prints all commands \n"
					+ "'login {username}' - login as {username} \n"
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
		
		
		
		
		
		
		
		
		default:{
			System.out.println("Unknown command");
			break;
		}
		}
	}
}
