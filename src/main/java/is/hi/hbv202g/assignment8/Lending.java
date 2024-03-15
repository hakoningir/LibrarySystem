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
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
