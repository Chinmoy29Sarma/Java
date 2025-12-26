package libraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    static ArrayList<Book> books = new ArrayList<>();
    static private HashMap<Integer , LibraryMember> libMembers = new HashMap<>();
    static private ArrayList<Integer> memberId = new ArrayList<>();

    // add a new book in the library
    public void addBook(Book book){
        books.add(book);
    }

    // search a book
    public boolean searchBook(String book){
        for(Book b: books){
            if(b.name.equals(book)){
                return true;
            }
        }
        return false;
    }

    // add member
    public void addMember(LibraryMember member){
        libMembers.put(member.id, member);
        memberId.add(member.id);
    }

    // get member
    public LibraryMember getMember(int id){
        return libMembers.get(id);
    }

    // get member name
    public void memberName(int id){
        System.out.println("The member name is : "+ libMembers.get(id).name);
    }

    // exist member
    public boolean isExist(int id){
        return libMembers.containsKey(id);
    }

    public static void main(String[] args) {

        Library library = new Library();

        // add new book
        Book book = new Book();
        book.addNewBook();

        // print book info
        System.out.println(books.getFirst().name);
        System.out.println(books.getFirst().author);
        System.out.println(books.getFirst().id);

        // User Registration
        RegisterUser register = new RegisterUser();
        register.registerUser();

        // print member info
        System.out.println(libMembers.isEmpty());
        library.memberName(memberId.getFirst());

        // Issue a book
        Issue s = new Issue();
        s.borrow();

        int id = memberId.getFirst();
        LibraryMember person = libMembers.get(id);
        System.out.println(person.book.getFirst().bookName);

        // Return a book
        ReturnBook ret = new ReturnBook();
        ret.returnBook();
    }
}
