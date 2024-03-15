package is.hi.hbv202g.assignment8;

import java.util.List;

public class Book {
    String title;
    List<Author> authors;
    public Book(String title, String authorName) throws UserOrBookDoesNotExistException, EmptyAuthorListException {
        this.title = title;
        this.authors = List.of(new Author(authorName));
        throw new UserOrBookDoesNotExistException("Book "+title+" not found"); 
    }
    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        this.title = title;
        this.authors = authors;
        throw new EmptyAuthorListException("No authors found" + authors.isEmpty());
    }
    public List<Author> getAuthors() {
        return this.authors;
    }
    public void setAuthors(List<Author> authors) throws EmptyAuthorListException {
        this.authors = authors;
        throw new EmptyAuthorListException("No authors found" + authors.isEmpty());
    }
    public void addAuthor(Author author) throws EmptyAuthorListException {
        this.authors.add(author);
        throw new EmptyAuthorListException("No authors found" + authors.isEmpty());
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
