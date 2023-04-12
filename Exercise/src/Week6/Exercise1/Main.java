package Week6.Exercise1;

import Week6.Exercise1.util.AgeCalculator;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date myDate1 = new Date(1999, 4, 13);
        Date myDate2 = new Date(2002, 4, 12);

        Date myDate3 = new Date(2000, 5, 8);
        Date myDate4 = new Date(2010, 8, 17);

        Person p1 = new Person("John", myDate1, myDate2);
        Person p2 = new Person("kane", myDate3, myDate4);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        if(p1.equals(p2)){
            System.out.println("Same person");
        }else{
            switch(AgeCalculator.isOlder(p1, p2)) {
                case 1:
                    System.out.println(p1.getName() + " is older than " + p2.getName());
                    break;
                case 0:
                    System.out.println("they are same ages");
                    break;
                case -1:
                    System.out.println(p2.getName() + " is older than " + p1.getName());
            }
        }
    }
}
