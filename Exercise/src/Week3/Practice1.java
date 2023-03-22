package Week3;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String str = keyboard.nextLine();
        int index = str.indexOf(",");
        int num1 = Integer.parseInt(str.substring(0, index));
        int num2 = Integer.parseInt(str.substring(index+1));

        System.out.println("dividend: " + num1);
        System.out.println("divisor: " + num2);
        System.out.println("quotient: " + num1 / num2);
        System.out.println("remainder: " + num1 % num2);

        keyboard.close();


    }
}
