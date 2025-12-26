package libraryManagementSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class ReturnBook {
    Scanner sc = new Scanner(System.in);
    Library library = new Library();

    public void returnBook(){
        System.out.print("Enter your id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the book name : ");
        String book = sc.nextLine();

        LibraryMember member = library.getMember(id);
        IssueInfo information = null;
        int i=0;
        for(IssueInfo info: member.book){
            if(info.bookName.equals(book)){
                information = info;
                break;
            }
            i++;
        }
        member.book.remove(i);

        LocalDate today = LocalDate.now();
       try{
           if(information.returnDate.getDayOfMonth() < today.getDayOfMonth() ||
                   information.returnDate.getMonthValue() < today.getMonthValue() ||
                   information.returnDate.getYear() < today.getYear()){
               System.out.println("You need to pay a penalty");
           }
       }catch (Exception err){
           System.out.println(err);
       }
        System.out.println("You successfully returned the book.");
    }
}
