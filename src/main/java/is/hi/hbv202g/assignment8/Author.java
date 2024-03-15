package is.hi.hbv202g.assignment8;

public class Author {
    String name;
    public Author(String name) throws EmptyAuthorListException {
        this.name = name;
        throw new EmptyAuthorListException(name + " is not a valid author");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
