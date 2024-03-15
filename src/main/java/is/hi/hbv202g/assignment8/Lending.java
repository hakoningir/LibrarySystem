package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

public class Lending {
    private Book book;
    private LocalDate dueDate;
    private User user;
    public Lending(Book book, User user) {
        this.dueDate = LocalDate.now().plusDays(30);
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) throws UserOrBookDoesNotExistException {
        this.book = book;
        throw new UserOrBookDoesNotExistException("Book "+book+" not found");
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) throws UserOrBookDoesNotExistException{
        this.user = user;
        throw new UserOrBookDoesNotExistException("User "+user+" not found");
    }
}
