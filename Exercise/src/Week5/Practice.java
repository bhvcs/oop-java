package Week5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str, "./ ");

        Student stu1 = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        str = sc.nextLine();
        Student stu2 = new Student(str, stu1.getYear());
        if(stu1.checkDate(stu1.getMonth(), stu1.getDay()) && stu2.checkDate(stu2.getMonth(),stu2.getDay())){
            System.out.println(stu1.toString());
            System.out.println(stu2.toString());
            if(stu1.isOlder(stu2)){
                System.out.printf("%s is older than %s", stu1.getName(), stu2.getName());
            }else{
                System.out.printf("%s is older than %s", stu2.getName(), stu1.getName());
            }
        }
        else{
            System.out.println("invalid input");
        }
    }
}
