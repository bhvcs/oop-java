package Week6.Exercise1.util;

import Week6.Exercise1.Person;

import java.util.Date;

public class AgeCalculator {
    public static int calAge(Person p){
        int age;
        if(p.getDied() == null){
            Date now = new Date();
            age = 1900 + now.getYear() - p.getBorn().getYear();
            if( now.getMonth() + 1 < p.getBorn().getMonth() ){
                age--;
                return age;
            }
            else if( now.getDate() < p.getBorn().getDate()){
                age--;
                return age;
            }
        }else{
            age = p.getDied().getYear() - p.getBorn().getYear();
            if( p.getDied().getMonth() < p.getBorn().getMonth() ){
                age--;
                return age;
            }
            else if( p.getDied().getDate() < p.getBorn().getDate()){
                age--;
                return age;
            }
        }
        return age;
    }
    public static int isOlder(Person p1, Person p2){
        int age1 = calAge(p1);
        int age2 = calAge(p2);
        if( age1 > age2) return 1;
        else{
            if( age1 == age2 ) return 0;
            else return -1;
        }
    }
}
