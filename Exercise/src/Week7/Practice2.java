package Week7;

import java.util.Arrays;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] arr = new char[4][4];
        char[][] answer= {
                {'1', '3', '5' , '7'},
                {'2', '4', '6' , '8'},
                {'1', '3', '5' , '7'},
                {'2', '4', '6' , '8'},
        };//
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                arr[i][j] = '*';
            }
        }
        while(!isFinish(arr)){
            for(int i = 0; i < 5; i++){
                if(i==0) System.out.print(" ");
                else System.out.printf("%3d", i);
            }
            System.out.println();
            for(int i = 0; i < 4; i++){
                System.out.print(i+1);
                for(int j = 0; j < 4; j++){
                    System.out.printf("%3c", arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.print("Enter Coordinate: ");
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            int d = sc.nextInt()-1;

            if(answer[a][b] == answer[c][d]){
                arr[a][b] = answer[a][b];
                arr[c][d] = answer[c][d];
            }
        }


    }
    public static boolean isFinish(char[][] array){
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                if(array[i][j] == '*') return false;
            }
        }
        return true;
    }
}
