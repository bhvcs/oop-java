package Week11.Practice1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        try{
            a = sc.nextInt();
            b = sc.nextInt();
            if(isCoprime(a, b)) System.out.println("Coprime");
            else System.out.println("not Coprime");
        }catch(InputMismatchException e){
            System.out.println("InputMismatchException");
        }catch(MyException e){
            System.out.println(e.getMessage());
        }

    }
    public static boolean isCoprime(int a, int b) throws MyException{
        if(a <= 1 || b<= 1) throw new MyException("One of a and b is less or equal to 1", 1);
        else if( a == b) throw new MyException("a and b are the same number", 2);
        else if( a > 10000 && b > 10000) throw new MyException("Both a and b are larger than 10000", 3);
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        if(a == 1) return true;
        else return false;
    }
}
