package Week4;

import java.util.Random;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        int p1Score = 0, p2Score = 0, score = 0;
        String p1 = "You", p2 = "Computer";
        String playerName = p1;
        int randomNum = 0;
        String action;
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        while( p1Score < 100 && p2Score < 100){
            if(playerName == p1){
                if(score == 0){
                    System.out.print("("+ p1 + ") insert action r(roll): ");
                    action = sc.nextLine();
                }else {
                    System.out.print("(" + p1 + ") insert action r(roll), h(hold): ");
                    action = sc.nextLine();
                }
                if(action.equals("h")){
                    System.out.println("("+ p1 + ") " + score + " added to You");
                    p1Score += score;
                    System.out.println("("+ p1 + ") Your score " + p1Score + ", Computer score " + p2Score);
                    score = 0;
                    playerName = p2;
                    continue;
                }
                if(action.equals("r")){
                    randomNum = rnd.nextInt(6)+1;
                    System.out.println("(" + p1 + ") dice rolled : " + randomNum);
                    if(randomNum == 1){
                        System.out.println("("+ p1 + ") No score added");
                        System.out.println("("+ p1 + ") Your score " + p1Score + ", Computer score " + p2Score);
                        score = 0;
                        playerName = p2;
                    }else {
                        score += randomNum;
                    }
                }
            } else if(playerName == p2) {
                if(score == 0){
                    System.out.println("("+ p2 + ") insert action r(roll): r");
                }else {
                    System.out.println("(" + p2 + ") insert action r(roll), h(hold): r");
                }
                randomNum = rnd.nextInt(6)+1;
                System.out.println("(" + p2 + ") dice rolled : " + randomNum);
                if(randomNum == 1){
                    score = 0;
                    System.out.println("("+ p2 + ") No score added");
                    System.out.println("("+ p2 + ") Your score " + p1Score + ", Computer score " + p2Score);
                    playerName = p1;
                    continue;
                }
                score += randomNum;
                if(score >= 20){
                    p2Score += score;
                    System.out.println("("+ p2 + ") " + score + " added to You");
                    System.out.println("("+ p2 + ") Your score " + p1Score + ", Computer score " + p2Score);
                    score = 0;
                    playerName = p1;
                }
            }
        }
        if(p1Score >= 100){
            System.out.println("(Game) Your score " + p1Score + ", Computer score " + p2Score + "\nCongratulations! You Win!");
        } else if (p2Score >= 100) {
            System.out.println("(Game) Your score " + p1Score + ", Computer score " + p2Score + "\nSorry, the computer wins.");
        }
    }
}