package com.librarymanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
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
	
	
	
	
	 public void saveBooksToFile() {
		 File save = new File("books.txt");
		 
		 try {
			save.createNewFile();
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
	 
	 
	 
	 
	 
	 
//	 
//	    public void saveBooksToFile() {
//	    	String name = "books.txt";
//	        try{
//	            File save = new File(name);
//	            if (save.createNewFile()) {
//	                try {
//	                    FileWriter saver = new FileWriter(name);
//	                    
//	                    for(Book book: database.getBooks()) {
//	       				 saver.write(book.getTitle() + "," + book.getAuthor() + "," + book.getISBN() + "\n");
//	       			 }
//	                    
//	                    saver.close();
//	                } catch (IOException e) {
//	                    System.out.println("An error occurred");
//	                    e.printStackTrace();
//	                }
//	                
//	                System.out.println("Game saved in: " + save.getName());
//	            } else System.out.println("Save already exists");
//	            
//	        }catch(IOException e){
//	            System.out.println("An error occurred");
//	            e.printStackTrace();
//	        }
//	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	public void loadBooksFromFile() {
		try(Scanner scan  = new Scanner(Paths.get("books.txt"))){
			 if(scan.hasNextLine()){
				 String row = scan.nextLine();
				 String[] book = row.split(",");
				 database.add(new Book(book[0], book[1], Integer.valueOf(book[2])));
			 }
			
		} catch(Exception e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
	}
	
	
	
	public void saveUsersToFile() {
		
	}
	
	public void loadUsersFromFile() {
		
	}
	
	public void startProgramLogic() {
		loadBooksFromFile();
		loadUsersFromFile();
	}

	public void endProgramLogic() {
		saveBooksToFile();
		saveUsersToFile();
	}
}
