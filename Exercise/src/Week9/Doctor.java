package Week9;

import Week6.Exercise1.Person;

import java.util.Date;

public class Doctor extends Person {
    private String hospital;
    public Doctor(String name, Date born, Date died, String hospital) {
        super(name, born, died);
        this.hospital = hospital;
    }

    @Override
    public String toString(){
        return "[Doctor]" + super.toString() + ", Affiliation : " + this.hospital;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public boolean equals(Doctor d) {
        return super.equals(d) && this.hospital.equals(d.getHospital());
    }

    public void examination(Patient p){
        System.out.println("I haven’t decided my major yet");
    }
}
