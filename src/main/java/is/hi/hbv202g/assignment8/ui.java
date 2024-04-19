package is.hi.hbv202g.assignment8;

import java.util.Scanner;

public class ui {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public ui() throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        librarySystem = new LibrarySystem();
        scanner = new Scanner(System.in); // Initialize once and reuse
    }

    public void start() throws EmptyAuthorListException {
        while (true) {
            System.out.println("1. Faculty member");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print(": ");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); 
                switch (input) {
                    case 1:
                        facultyInterface();
                        break;
                    case 2:
                        studentInterface();
                        break;
                    case 3:
                        System.out.println("Exiting system...");
                        return; 
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } else {
                System.out.println("Please enter a valid number");
                scanner.next(); 
            }
        }
    }

    public void facultyInterface() {
        System.out.println("Choose faculty member");
        int index = 1;
        for (FacultyMember facultyMember : librarySystem.getFacultyMembers()) {
            System.out.println(index++ + ". " + facultyMember.getName());
        }
        System.out.print(index + ". Exit");
        System.out.print(": ");
        int input = scanner.nextInt();
        scanner.nextLine();
        if(input == index) {
            System.out.println("Exiting faculty member interface...");
            return;
        }
        while (true) {
            FacultyMember facultyMember = librarySystem.getFacultyMembers().get(input - 1);
            System.out.println("Signed in as " + facultyMember.getName());
            System.out.println("Department: " + facultyMember.getDepartment());
            System.out.println("Who are you?");
            int studentIndex = 1;
            for (Student student : librarySystem.getStudents()) {
                System.out.println(studentIndex++ + ". " + student.getName());
            }
            System.out.println(studentIndex + ". Exit");
            System.out.print(": ");
            input = scanner.nextInt();
            scanner.nextLine();
            if(input == studentIndex) {
                System.out.println("Exiting faculty member interface...");
                return;
            }
            Student student = librarySystem.getStudents().get(input - 1);
            System.out.println("Choose action");
            System.out.println("1. Loan book");
            System.out.println("2. Return book");
            System.out.println("3. Exit");
            System.out.print(": ");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    System.out.println("Choose a book to loan");
                    int bookIndex = 1;
                    for (Book book : librarySystem.getAvailableBooks()) {
                        System.out.println(bookIndex++ + ". " + book.getTitle());
                    }
                    System.out.print(": ");
                    int bookInput = scanner.nextInt();
                    scanner.nextLine();
                    Book selectedBook = librarySystem.getAvailableBooks().get(bookInput - 1);
                    try {
                        librarySystem.loanBook(selectedBook, student, facultyMember);
                        System.out.println("Book loaned successfully");
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case 2:
                    if(librarySystem.getLentBooks().isEmpty()) {
                        System.out.println("No books to return");
                        break;
                    }
                    else {
                        System.out.println("Choose a book to return");
                    }
                    int lentBookIndex = 1;
                    for (Lent lent : librarySystem.getLentBooks()) {
                        System.out.println(lentBookIndex++ + ". " + lent.getBookTitle());
                    }
                    System.out.print(": ");
                    int lentBookInput = scanner.nextInt();
                    scanner.nextLine();
                    selectedBook = librarySystem.getBookByTitle(librarySystem.getLentBooks().get(lentBookInput - 1).getBookTitle());
                    librarySystem.returnBook(facultyMember, selectedBook);
                    System.out.println("Book returned successfully");
                    break;
                case 3:
                    System.out.println("Exiting faculty member interface...");
                    return;
                default:
                    System.out.println("Invalid input");
                    break;        
            }
        }
    }

    public void studentInterface() {
        System.out.println("Choose student");
        int index = 1;
        for (Student student : librarySystem.getStudents()) {
            System.out.println(index++ + ". " + student.getName());
        }
        System.out.print(": ");
        int input = scanner.nextInt();
        scanner.nextLine();
        Student student = librarySystem.getStudents().get(input - 1);
        while (true) {
            System.out.println("Signed in as " + student.getName());
            System.out.println("What would you like to do?");
            System.out.println("1. View my loans");
            System.out.println("2. Return book and pay fee");
            System.out.println("3. Find a book to loan");
            System.out.println("4. Exit");
            System.out.print(": ");
            input = scanner.nextInt();
            scanner.nextLine();
            if(input == 1) {
                if(librarySystem.getLentBooks().isEmpty()) {
                    System.out.println("No books loaned");
                }
                else {
                    System.out.println("Books loaned:");
                    for (Lent lent : librarySystem.getLentBooks()) {
                        if (lent.getUserName().equals(student.getName())) {
                            System.out.println(lent.getBookTitle());
                        }
                    }
                }
            }
            else if(input == 2) {
                if(librarySystem.getLentBooks().isEmpty()) {
                    System.out.println("No books to return");
                }
                else {
                    System.out.println("Choose a book to return");
                    int indexBook = 1;
                    for (Lent books : librarySystem.getLentBooks()) {
                        if (books.getUserName().equals(student.getName())) {
                            System.out.println(indexBook++ + ": " + books.getBookTitle());
                        }
                    }
                    System.out.print(": ");
                    int bookInput = scanner.nextInt();
                    scanner.nextLine();
                    Book getBook = librarySystem.getBookByTitle(librarySystem.getLentBooks().get(bookInput - 1).getBookTitle());
                    System.out.println("Choose faculty member that will return the book:");
                    int nameIndex = 1;
                    for (FacultyMember facultyMember : librarySystem.getFacultyMembers()) {
                        System.out.println(nameIndex++ + ". " + facultyMember.getName());
                    }
                    System.out.print(": ");
                    int nameInput = scanner.nextInt();
                    scanner.nextLine();
                    FacultyMember facultyMemberName = librarySystem.getFacultyMembers().get(nameInput - 1);
                    librarySystem.returnBook(facultyMemberName, getBook);
                    student.setFeePaid(true);
                    System.out.println("Fee paid successfully");
                }
            }
            else if(input == 3) {
                System.out.println("Choose a book to loan");
                int bookIndex = 1;
                for (Book book : librarySystem.getAvailableBooks()) {
                    System.out.println(bookIndex++ + ". " + book.getTitle());
                }
                System.out.print(": ");
                int bookInput = scanner.nextInt();
                scanner.nextLine();
                Book selectedBook = librarySystem.getAvailableBooks().get(bookInput - 1);
                System.out.println("Name of faculty member that will loan the book:");
                int nameIndex = 1;
                for (FacultyMember facultyMember : librarySystem.getFacultyMembers()) {
                    System.out.println(nameIndex++ + ". " + facultyMember.getName());
                }
                System.out.print(": ");
                int nameInput = scanner.nextInt();
                scanner.nextLine();
                FacultyMember facultyMemberName = librarySystem.getFacultyMembers().get(nameInput - 1);
                try {
                    librarySystem.loanBook(selectedBook, student, facultyMemberName);
                    System.out.println("Book loaned successfully");
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
            else if(input == 4) {
                System.out.println("Exiting student interface...");
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        }   
    }

    public void close() {
        scanner.close(); 
    }

    public static void main(String[] args) {
        try {
            ui ui = new ui();
            ui.start();
            ui.close();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
