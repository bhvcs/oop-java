package Week4;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string S: ");
        String S = sc.nextLine();
        int left;
        int right;
        String evenPalindrome = "";
        String oddPalindrome = "";
        String tmpPalin = "";
        String Palindrome;

        for (int std = 0; std < S.length(); std++) {
            left = std;
            right = std + 1;
            while (left >= 0 && right < S.length()) {
                if (S.charAt(left) == S.charAt(right)) {
                    tmpPalin = S.substring(left, right + 1);
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (evenPalindrome.length() < tmpPalin.length()) {
                evenPalindrome = tmpPalin;
            } else if (evenPalindrome.length() == 0)
                evenPalindrome = S.substring(0, 1);
        }


        tmpPalin = "";

        for(int std = 0; std < S.length(); std++){
            left = std -1;
            right = std + 1;
            while(left >= 0 && right < S.length()){
                if(S.charAt(left) == S.charAt(right)){
                    tmpPalin = S.substring(left, right + 1);
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(oddPalindrome.length() < tmpPalin.length()){
                oddPalindrome = tmpPalin;
            }else if(oddPalindrome.length() == 0){
                oddPalindrome = S.substring(0,1);
            }
        }
        if(oddPalindrome.length() < evenPalindrome.length()){
            Palindrome = evenPalindrome;
        }else{
            Palindrome = oddPalindrome;
        }
        System.out.println("Longest Palindrome: " + Palindrome);
    }
}
