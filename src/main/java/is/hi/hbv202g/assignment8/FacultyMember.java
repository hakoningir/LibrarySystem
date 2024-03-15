package is.hi.hbv202g.assignment8;

public class FacultyMember {
    String name;
    String department;
    public FacultyMember(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }    
}
