package libraryManagementSystem;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Issue {

    Scanner sc = new Scanner(System.in);
    Library library = new Library();

//    Date date = new Date()
    

    // Borrow a book
    public void borrow(){
        System.out.print("Enter your id : ");
        int id = sc.nextInt();
        sc.nextLine();
        // Not a member
        if(!library.isExist(id)){
            System.out.println("You are not a member. Kindly Register First.");
            return;
        }

        System.out.print("Enter the book name : ");
        String bookName = sc.nextLine();

        // check if book is there or not
        if(!library.searchBook(bookName)){
            System.out.println("Currently the book is not available.");
            return;
        }

        // if user exist & book available then issue the book
        LocalDate issueDate = LocalDate.now();

        // Suppose library allows 7 days for returning a book
        LocalDate dueDate = issueDate.plusDays(7);

        // get the member
        LibraryMember member = library.getMember(id);
        IssueInfo info = new IssueInfo(bookName, issueDate, dueDate);
        member.book.add(info);
        System.out.println("Congratulations! You are issued the book.");
        return;
    }
}
