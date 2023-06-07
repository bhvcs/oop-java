package Week14.Practice1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Input max number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> primeNums = Eratos.sieve(n);
        Iterator<Integer> i = primeNums.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }
}
