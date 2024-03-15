package is.hi.hbv202g.assignment8;

public class User {
    String name;
    public User(String name) throws UserOrBookDoesNotExistException {
        this.name = name;
        throw new UserOrBookDoesNotExistException(name + " is not a valid user");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) throws UserOrBookDoesNotExistException {
        this.name = name;
        throw new UserOrBookDoesNotExistException(name + " is not a valid user");
    }
}
