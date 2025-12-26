package libraryManagementSystem;

import java.util.Scanner;
import java.util.Random;
public class RegisterUser {
    Scanner sc = new Scanner(System.in);
    // Register user
    public void registerUser(){
        // Taking information from user
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        // generate random number
        Random random = new Random();
        int id = Math.abs(random.nextInt());
        // Display the id of the user
        System.out.println("Your id is : "+ id);
        // make a LibraryMember object
        LibraryMember user = new LibraryMember(id, name);
        // Saving information to the data base
        Library library = new Library();
        library.addMember(user);
    }
}
