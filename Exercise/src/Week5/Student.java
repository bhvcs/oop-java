package Week5;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Student {
    Random rnd = new Random();
    private String name;
    private int year;
    private int month;
    private int day;
    public Student(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.month = rnd.nextInt(12)+1;
        while(true){
            int tmpDay = rnd.nextInt(31)+1;
            if(checkDate(this.month, tmpDay)){
                this.day = tmpDay;
                break;
            }
        }
    }

    public boolean checkDate(int month, int day) {
        if( month <= 12 && day <= 31){
            if (month <= 7) {
                if(month ==2){
                    return day <= 29;
                }
                if (month % 2 == 0) {
                    return day <= 30;
                }else {
                    return true;
                }
            } else {
                if (month % 2 == 1) {
                    return day <= 30;
                }else{
                    return true;
                }
            }
        }else{
            return false;
        }

    }
    public boolean isOlder(Student std){
        if(this.year  < std.getYear()){
            return true;
        }else if(this.year  > std.getYear()){
            return false;
        }else{
            if(this.month  < std.getMonth()){
                return true;
            }else if(this.month  > std.getMonth()){
                return false;
            }else{
                if(this.day  < std.getDay()){
                    return true;
                }
                else return false;
            }
        }
    }
    public String toString(){
        return String.format("%s %d/%d/%d age: %d", name, year, month, day, this.calAge());
    }
    public int calAge(){
        Calendar calendar1 = new GregorianCalendar(year, month, day);
        Calendar now = new GregorianCalendar();

        int age = now.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
        if(calendar1.get(Calendar.MONTH) > now.get(Calendar.MONTH)+1){
            age--;
        }else if (calendar1.get(Calendar.MONTH) == now.get(Calendar.MONTH)+1){
            if(calendar1.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH)){

                age--;
            }
        }
        return age;
    }
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
