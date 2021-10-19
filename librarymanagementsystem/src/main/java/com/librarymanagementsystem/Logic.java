package com.librarymanagementsystem;

import java.util.Scanner;

public class Logic {
	Scanner scanner = new Scanner(System.in);
	Database database = new Database();
	
	public void add() {
		System.out.println("Enter book info in the following format: {title},{author},{ISBN}");
		System.out.print("> ");
		String informations = scanner.next();
		
		String[] info = informations.split(",");
		
		database.add(new Book(info[0], info[1], Integer.valueOf(info[2])));
	}
	
	public void delete() {
		System.out.println("Enter ISBN of book you want to delete");
		System.out.print("> ");
		int isbn = scanner.nextInt();
		
		
	}
	
	public void list() {
		database.list();
	}
	
	public void saveBookToFile() {
		
	}
	
	public void loadBooksFromFile() {
		
	}
}
