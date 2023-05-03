package Week9;

import Week6.Exercise1.Person;

import java.util.Date;

public class Patient extends Person {
    private String department;

    public Patient(String name, Date born, Date died, String department) {
        super(name, born, died);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString(){
        return "[Patient]" + super.toString() + ", department : " + this.department;
    }
}
