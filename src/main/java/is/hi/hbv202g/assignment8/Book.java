package is.hi.hbv202g.assignment8;

import java.util.List;

public class Book {
    String title;
    List<Author> authors;
    public Book(String title, String authorName) throws EmptyAuthorListException {
        this.title = title;
        this.authors = List.of(new Author(authorName));
    }
    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        this.title = title;
        this.authors = authors;
    }
    public List<Author> getAuthors() {
        return this.authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public void addAuthor(Author author) {
        this.authors.add(author);
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
