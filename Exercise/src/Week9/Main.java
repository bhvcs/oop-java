package Week9;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date myDate1 = new Date(1999, 4, 13);
        Date myDate2 = new Date(2002, 4, 12);

        Date myDate3 = new Date(2000, 5, 8);
        Date myDate4 = new Date(2010, 8, 17);

        Date myDate5 = new Date(1997, 2, 23);

        Patient patient1 = new Patient("patient1", myDate1, myDate2, "internal");
        Patient patient2 = new Patient("patient2", myDate3, myDate4, "surgery");
        Patient patient3 = new Patient("patient3", myDate5, null, "dental");

        Doctor doctor1 = new Doctor("Doctor1", myDate1, myDate4, "sebrance");
        Doctor doctor2 = new Doctor("Doctor2", myDate1, myDate4, "sebrance");

        Physician physician = new Physician("Physician", myDate2, null, "meongdong");

        if (doctor1.equals(doctor2)) {
            System.out.println("same doctor");
        } else {
            System.out.println("other doctor");
        }
        System.out.println(doctor1.toString());
        System.out.println(doctor2.toString());
        System.out.println(patient1.toString());
        System.out.println(patient2.toString());
        System.out.println(patient3.toString());
        System.out.println(physician.toString());
        doctor1.examination(patient1);
        physician.examination(patient1);
        physician.examination(patient2);
        physician.examination(patient3);
    }
}
