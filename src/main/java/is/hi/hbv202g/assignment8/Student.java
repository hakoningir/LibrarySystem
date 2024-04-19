package is.hi.hbv202g.assignment8;

public class Student extends User{
    Boolean feePaid;
    public Student(String name, Boolean feePaid) throws UserOrBookDoesNotExistException {
        super(name);
        this.feePaid = feePaid;
    }

    public boolean isFeePaid() {
        return feePaid;
    }
    
    public void setFeePaid(Boolean feePaid) {
        this.feePaid = feePaid;
    }

    public void payFee(){
        feePaid = true;
    }
}
