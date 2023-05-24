package Week12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearch {
    public static void main(String[] args) {
        int[] targets = new int[100];
        int[] array = new int[100000];
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\2023_ite2037_2020036217\\Exercise\\src\\Week12\\input.txt"));
            for(int i = 0; i < 100; i++){
                targets[i] = Integer.parseInt(br.readLine());
            }
            for(int i = 0; i < 100000; i++){
                array[i] = Integer.parseInt(br.readLine());
            }
            for(int i = 0; i < 100; i++){
                System.out.printf("target: %d\tindex: %d\n", targets[i], binSearch(array, 0, 100000-1, targets[i]));
            }
        }catch(FileNotFoundException e){
            System.out.println("input.txt was not found");
            System.exit(0);
        }catch(IOException e){
            System.out.println("Error reading from input.txt");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static int binSearch(int[] array, int start, int end, int target){
        if(start <= end){
            int middle = (start + end)/2;
            if(array[middle] < target) return binSearch(array, middle+1, end, target);
            else if(array[middle] == target) return middle;
            else return binSearch(array, start, middle-1, target);
        }else return -1;
    }
}
