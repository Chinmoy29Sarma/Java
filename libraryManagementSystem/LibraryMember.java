package libraryManagementSystem;

import java.util.ArrayList;

public class LibraryMember {
    int id;
    String name;
    ArrayList<IssueInfo> book = new ArrayList<>();

    public LibraryMember(int id, String name){
        this.id = id;
        this.name = name;
    }
}
