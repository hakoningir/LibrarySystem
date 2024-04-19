package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books = new ArrayList<>();
    private List<FacultyMember> facultyMembers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Lent> lentBooks = new ArrayList<>();

    public LibrarySystem() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        initializeAuthorsAndBooks();
        initializeFacultyMembers();
        initializeStudents();
    }

    private void initializeAuthorsAndBooks() throws EmptyAuthorListException {
        Author jk = new Author("J.K. Rowling");
        Author jrr = new Author("J.R.R. Tolkien");
        Author doyle = new Author("Arthur Conan Doyle");
        Author dickens = new Author("Charles Dickens");

        List<Author> hpAuthors = List.of(jk);
        List<Author> lotrAuthors = List.of(jrr);
        List<Author> doyleAuthors = List.of(doyle);
        List<Author> dickensAuthors = List.of(dickens);

        books.addAll(List.of(
            new Book("Harry Potter and the Philosopher's Stone", hpAuthors, false),
            new Book("Harry Potter and the Chamber of Secrets", hpAuthors, false),
            new Book("Lord of the Rings: The Fellowship of the Ring", lotrAuthors, false),
            new Book("Lord of the Rings: The Two Towers", lotrAuthors, false),
            new Book("Sherlock Holmes: A Study in Scarlet", doyleAuthors, false),
            new Book("Sherlock Holmes: The Sign of four", doyleAuthors, true),
            new Book("Sherlock Holmes: The Hound of the Baskervilles", doyleAuthors, true),
            new Book("A tale of two cities", dickensAuthors, false)
        ));
    }

    private void initializeFacultyMembers() throws UserOrBookDoesNotExistException {
        facultyMembers.addAll(List.of(
            new FacultyMember("Hilmar", "dep.1"),
            new FacultyMember("Sigríður", "dep.1"),
            new FacultyMember("Hilmar", "dep.1"),
            new FacultyMember("Sigríður", "dep.1"),
            new FacultyMember("Pálína", "dep.1"),
            new FacultyMember("Reynir", "dep.2"),
            new FacultyMember("Arnar", "dep.2"),
            new FacultyMember("Hjalti", "dep.3"),
            new FacultyMember("Heiðrún", "dep.3"),
            new FacultyMember("Sóley", "dep.3")
        ));
    }

    private void initializeStudents() throws UserOrBookDoesNotExistException {
        students.addAll(List.of(
            new Student("Árni", true),
            new Student("Björn", false),
            new Student("Kolfinna", true),
            new Student("Sigrún", false),
            new Student("Atli", false),
            new Student("Bjarki", true),
            new Student("Rebekka", false)
        ));
    }

    public List<FacultyMember> getFacultyMembers() {
        return facultyMembers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isLent()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Lent> getLentBooks() {
        return lentBooks;
    }

    public void loanBook(Book book, Student student, FacultyMember facultyMember) {
        if (student != null && facultyMember != null && books.contains(book)) {
            lentBooks.add(new Lent(book.getTitle(), book.getAuthors(), student.getName(), LocalDate.now(), LocalDate.now().plusDays(14)));
            student.setFeePaid(false);
            book.setLent(true);
        }
    }

    public void returnBook(FacultyMember facultyMember, Book book) {
        if (facultyMember != null && books.contains(book)) {
            lentBooks.removeIf(lent -> lent.getBookTitle().equals(book.getTitle()));
            book.setLent(false);
        }
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
