package is.hi.hbv202g.assignment8;

import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private boolean isLent = false;

    public Book(String title, List<Author> authors, boolean isLent) throws EmptyAuthorListException{
        this.title = title;
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Author list is empty");
        }
        this.authors = authors;
        this.isLent = isLent;
    }
    public void addAuthor(Author author){
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        if (authors.isEmpty()){
            throw new EmptyAuthorListException("Author list is empty");
        }
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLent() {
        return isLent;
    }

    public void setLent(boolean lent) {
        isLent = lent;
    }
}
