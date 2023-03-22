package Week3;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {

        String name1, name2, name3;
        int quantity1, quantity2, quantity3;
        double price1, price2, price3, total1, total2, total3, subtotal;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of item 1:");
        name1 = scanner.nextLine();
        System.out.println("Enter quantity of item 1:");
        quantity1 = scanner.nextInt();
        System.out.println("Enter price of item 1:");
        price1 = scanner.nextDouble();
        total1 = quantity1 * price1;

        scanner.nextLine();

        System.out.println("Enter name of item 2:");
        name2 = scanner.nextLine();
        System.out.println("Enter quantity of item 2:");
        quantity2 = scanner.nextInt();
        System.out.println("Enter price of item 2:");
        price2 = scanner.nextDouble();
        total2 = quantity2 * price2;

        scanner.nextLine();

        System.out.println("Enter name of item 3:");
        name3 = scanner.nextLine();
        System.out.println("Enter quantity of item 3:");
        quantity3 = scanner.nextInt();
        System.out.println("Enter price of item 3:");
        price3 = scanner.nextDouble();
        total3 = quantity3 * price3;

        subtotal = total1 + total2 + total3;

        System.out.println("Your bill:");
        System.out.println("\n");
        System.out.printf("%-30s%-10s%-10s%-10s\n", "ITEM", "QUANTITY", "PRICE", "TOTAL");
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", name1, quantity1, price1, total1);
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", name2, quantity2, price2, total2);
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", name3, quantity3, price3, total3);
        System.out.println("\n");
        System.out.printf("%-50s%-10.2f\n", "SUBTOTAL", subtotal);
        System.out.printf("%-50s%-10.2f\n", "6.25% SALES TAX", subtotal * 0.0625);
        System.out.printf("%-50s%-10.2f\n", "TOTAL", subtotal * (1+0.0625));


    }
}
