package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    public LibrarySystem() {        
        List<Book> books = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<FacultyMember> facultyMembers = new ArrayList<>();
    }
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) throws UserOrBookDoesNotExistException {
        List<Author> authors = List.of(new Author(authorName));
        List<Book> books = List.of(new Book(title, authors));
        Book book = new Book(title, authorName);
        books.add(book);
        throw new UserOrBookDoesNotExistException("Book "+book+" not found");
    }
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) {
        List<Book> books = List.of(new Book(title, authors));
        Book book = new Book(title, authors);
        books.add(book);
    }
    public void addStudentUser(String name, boolean feePaid) {
        List<Student> students = List.of(new Student(name, feePaid));
        Student studentUser = new Student(name, feePaid);
        students.add(studentUser);
    }
    public void addFacultyMemberUser(String name, String department) {
        List<FacultyMember> facultyMembers = List.of(new FacultyMember(name, department));
        FacultyMember facultyMemberUser = new FacultyMember(name, department);
        facultyMembers.add(facultyMemberUser);
    }
    public Book findBookByTitle(String title) {
        return null;
    }
    public User findUserByName(String name) {
        return null;
    }
    public void borrowBook(User user, Book book) {
        return;
    }
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        return;
    }
    public void returnBook(User user, Book book) throws EmptyAuthorListException {
        if(book.getAuthors().isEmpty()) {
            throw new EmptyAuthorListException("No authors found");
        }
    }
}
