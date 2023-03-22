package Week3;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int percent = scanner.nextInt();
        String formatted = String.format("(%d/100)*4=%.0f", percent, ((double)percent/100)*4);
        System.out.println(formatted);

        scanner.close();
    }
}
