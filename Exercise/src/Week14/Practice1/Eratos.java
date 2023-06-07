package Week14.Practice1;

import java.util.ArrayList;

public class Eratos {
    public static ArrayList<Integer> sieve(int n){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i++){
            numbers.add(i);
        }
        numbers.remove(0);//1삭제
        int num = 0;//현재 2의 index
        while(num < numbers.size()-1){
            int p = numbers.size()-1;
            while(num < p){
                if(numbers.get(p) % numbers.get(num) == 0 ) numbers.remove(p);
                p--;
            }
            num++;
        }
        return numbers;
    }
}
