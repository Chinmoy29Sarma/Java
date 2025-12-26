package libraryManagementSystem;
import java.time.LocalDate;

public class IssueInfo {
    String bookName;
    LocalDate issueDate;
    LocalDate returnDate;

    IssueInfo(String bookName, LocalDate issueDate, LocalDate returnDate){
        this.bookName = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
}
