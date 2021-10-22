package com.librarymanagementsystem;

import java.util.ArrayList;

public class Database {
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	
	public ArrayList<Book> getBooks() {
		return books;
	}	

	public ArrayList<User> getUsers() {
		return users;
	}

	public void addBook(Book book) {
		books.add(book);
	}
	
	public void deleteBook(Book book) {
		books.remove(book);
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void listBooks() {
		for(Book book: books) {
			System.out.println(book.toString());
		}
	}
	
	public void listUsers() {
		for(User user: users) {
			System.out.println(user.toString());
		}
	}
	
}
