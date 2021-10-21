package com.librarymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
	private ArrayList<Book> books = new ArrayList<>();
	private Map<String, String> users = new HashMap<>();
	
	public ArrayList<Book> getBooks() {
		return books;
	}	

	public Map<String, String> getUsers() {
		return users;
	}

	public void add(Book book) {
		books.add(book);
	}
	
	public void delete(Book book) {
		books.remove(book);
	}
	
	public void list() {
		for(Book book: books) {
			System.out.println(book.toString());
		}
	}
	
}
