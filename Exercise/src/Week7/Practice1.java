package Week7;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int[] ar1 : drawSnail(n)){
            for(int el : ar1){
                System.out.printf("%3d", el);
            }
            System.out.println();
        }

    }
    public static int[][] drawSnail(int n){
        int[][] arr = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        int c,r = 0;

        for(int i = x; i < (n+1)/2; i++){
            for(int j = x; j < n; j++){
                if(arr[y][j] == 0) {
                    arr[y][j] = num++;
                    x = j;
                }
            }
            for(int j = y; j < n; j++){
                if (arr[j][x] == 0){
                    arr[j][x] = num++;
                    y = j;
                }
            }
            for(int j = x; j >= 0; j--){
                if (arr[y][j] == 0){
                    arr[y][j] = num++;
                    x = j;
                }
            }
            for(int j = y; j >= 0; j--){
                if (arr[j][x] == 0){
                    arr[j][x] = num++;
                    y = j;
                }
            }
        }

        return arr;
    }
}
