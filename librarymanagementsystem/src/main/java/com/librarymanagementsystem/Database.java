package com.librarymanagementsystem;

import java.util.ArrayList;

public class Database {
	private ArrayList<Book> books = new ArrayList<>();
	
	public ArrayList<Book> getBooks() {
		return books;
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
