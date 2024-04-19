package is.hi.hbv202g.assignment8;

import java.time.LocalDate;
import java.util.List;



public class Lent {
    private String bookTitle;
    private List<Author> authorName;
    private String userName;
    private LocalDate lentDate;
    private LocalDate returnDate;

    public Lent(String bookTitle, List<Author> authorName, String userName, LocalDate lentDate, LocalDate returnDate) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.userName = userName;
        this.lentDate = lentDate;
        this.returnDate = returnDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public List<Author> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<Author> authorName) {
        this.authorName = authorName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getLentDate() {
        return lentDate;
    }

    public void setLentDate(LocalDate lentDate) {
        this.lentDate = lentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
