package com.librarymanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
	Scanner scanner = new Scanner(System.in);
	Database database = new Database();
	
	public void addBook() {
		System.out.println("Enter book info in the following format: {title},{author},{ISBN}");
		System.out.print("> ");
		String informations = scanner.next();
		
		String[] info = informations.split(",");
		
		database.addBook(new Book(info[0], info[1], Integer.valueOf(info[2])));
		System.out.println("Book added");
	}
	
	public void removeBook() {
		System.out.println("Enter ISBN of book you want to delete");
		System.out.print("> ");
		int isbn = scanner.nextInt();
		
		
		for(Book book: database.getBooks()) {
			if(book.getISBN() == isbn) {
				database.deleteBook(book);
				System.out.println("Book deleted");
				break;
			}
		}
	}
	
	public boolean isAdmin(String username) {
		for(User user: database.getUsers()) {
			if(user.getUsername().equals(username) && user.isAdmin()) return true;
		}

		return false;
	}
	
	public void listBooks() {
		database.listBooks();
	}
	
	public void saveBooksToFile() {
		File save = new File("books.txt");
		 
		 try {
			save.createNewFile();
			new FileWriter("books.txt", false).close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 try {
			 FileWriter saver = new FileWriter("books.txt");
			 
			 for(Book book: database.getBooks()) {
				 saver.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "\n");
			 }
			 
			 saver.close();
			 
		 } catch (IOException e) {
			 }
		 } 
	
	public void loadBooksFromFile() {
		try(Scanner scan  = new Scanner(Paths.get("books.txt"))){
			 while(scan.hasNextLine()){
				 String row = scan.nextLine();
				 String[] book = row.split(",");
				 database.addBook(new Book(book[0], book[1], Integer.valueOf(book[2])));
			 }
			
		} catch(Exception e){
            System.out.println("An error occured ");
            e.printStackTrace();
        }
	}
	
	public void saveUsersToFile() {
		File save = new File("users.txt");
		

		 try {
			save.createNewFile();
			new FileWriter("users.txt", false).close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 try {
			 FileWriter saver = new FileWriter("users.txt");
			 
			 for(User user: database.getUsers()) {
				 saver.write(user.getUsername() + "," + user.getPassword() + "," + user.isAdmin() + "\n");
			 }
			 
			 saver.close();
			 
		 } catch (IOException e) {
			 }
	}
	
	public void loadUsersFromFile() {
		try(Scanner scan  = new Scanner(Paths.get("users.txt"))){
			 while(scan.hasNextLine()){
				 String row = scan.nextLine();
				 String[] data = row.split(",");
				 database.addUser(new User(data[0], data[1], Boolean.parseBoolean(data[2])));
			 }
			
		} catch(Exception e){
           System.out.println("An error occured ");
           e.printStackTrace();
       }
	}
	
	public void startProgramLogic() {
		loadBooksFromFile();
		loadUsersFromFile();
	}

	public void endProgramLogic() {
		saveBooksToFile();
		saveUsersToFile();
	}
	
	public boolean userExist(String username) {
		
		ArrayList<User> users = database.getUsers();
		
		for(User user: users) {
			if(user.getUsername().equals(username)) return true;
		}
		
		return false;
	}

	public boolean passwordIsCorrect(String username, String password) {
		ArrayList<User> users = database.getUsers();
		
		for(User user: users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) return true;
		}
		
		return false;
	}

	public void findBook() {
		System.out.println("Enter title, author or ISBN of the book you are looking for");
		String info = scanner.next();
		
		ArrayList<Book> foundBooks = new ArrayList<>();
		ArrayList<Book> books = database.getBooks();
		
		for(Book book: books) {
			int isbn = -1;
			
			try {
				isbn = Integer.valueOf(info);
			} catch (Exception e) {
				
			}
			
			if(book.getTitle().equals(info)  ||
			   book.getAuthor().equals(info) ||
			   book.getISBN() == isbn) foundBooks.add(book);
		}
		
		if(foundBooks.isEmpty()) System.out.println("");
		else {
			System.out.println("Books found: ");
			
			for(Book book: foundBooks) {
				System.out.println(book.toString());
			}
		}		
	}

	public void listUsers() {
		database.listUsers();
	}

	public void removeUser() {
		System.out.println("Enter username of user you want to delete");
		System.out.print("> ");
		String username = scanner.next();
		
		
		for(User user: database.getUsers()) {
			if(user.getUsername().equals(username)) {
				database.deleteUser(user);
				System.out.println("User deleted");
				break;
			}
		}
	}

	public void addUser() {
		System.out.println("Enter user info in the following format: {username},{password},{isAdmin(true/false)}");
		System.out.print("> ");
		String informations = scanner.next();
		
		String[] info = informations.split(",");
		
		database.addUser(new User(info[0], info[1], Boolean.parseBoolean(info[2])));
		
		System.out.println("User added");
	}
}
