package is.hi.hbv202g.assignment8;

public abstract class User {
    private String name;
    public User(String name) throws UserOrBookDoesNotExistException {
        if (name == null || name.trim().isEmpty()) {
            throw new UserOrBookDoesNotExistException("Invalid user name provided.");
        }
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws UserOrBookDoesNotExistException {
        if (name == null || name.trim().isEmpty()) {
            throw new UserOrBookDoesNotExistException("Invalid user name provided.");
        }
        this.name = name;
    }
    
}
