package com.librarymanagementsystem;

import java.util.ArrayList;

public class Database {
	private ArrayList<Book> books = new ArrayList<>();
//	private Map<String, String> users = new HashMap<>();
	
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
	
	public void list() {
		for(Book book: books) {
			System.out.println(book.toString());
		}
	}
	
}
