package libraryManagementSystem;

import java.util.Scanner;

public class Book {
    int id;
    String name, author;

    public Book(){

    }

    public Book(String name, String author, int id){
        this.name = name;
        this.author = author;
        this.id = id;
    }

    Scanner sc = new Scanner(System.in);
    Library library = new Library();
    // add book
    public void addNewBook(){
        System.out.print("Enter the book name : ");
        String name = sc.nextLine();
        System.out.print("Enter the author name : ");
        String author = sc.nextLine();

        Book book = new Book(name, author, ++id);
        // adding book to the data base
        library.addBook(book);
    }
}
