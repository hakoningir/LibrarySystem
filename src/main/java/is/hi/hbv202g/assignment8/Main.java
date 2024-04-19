package is.hi.hbv202g.assignment8;

public class Main {
    public static void main(String[] args) {
        try {
            ui userInterface = new ui();  
            userInterface.start();        
        } catch (EmptyAuthorListException | UserOrBookDoesNotExistException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
