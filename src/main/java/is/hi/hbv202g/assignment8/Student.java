package is.hi.hbv202g.assignment8;

public class Student {
    Boolean feePaid;
    public Student(String name, boolean feePaid) {
        this.feePaid = feePaid;
    }
    public boolean isFeePaid() {
        if(feePaid == true) {
            return true;
        }
        return false;
    }
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}
