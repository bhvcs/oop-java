package Week10.Practice2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Organism[][] organismBoard = new Organism[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Ant.getAnts().size() < 20) {
                    organismBoard[i][j] = new Ant(j, i);
                } else organismBoard[i][j] = null;
            }
        }
        organismBoard[3][2] = new DoodleBug(2, 3);
        organismBoard[3][5] = new DoodleBug(5, 3);
        //처음 초기화
        while (Ant.getAnts().size() != 0 && DoodleBug.getDoodleBugs().size() != 0) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (organismBoard[i][j] instanceof Ant) System.out.print('o');
                    else if (organismBoard[i][j] instanceof DoodleBug) System.out.print('x');
                    else System.out.print(" ");
                }
                System.out.println();
            }
            sc.nextLine();
            for (DoodleBug doodle : DoodleBug.getDoodleBugs()) {
                doodle.move(organismBoard);
            }//doodlebug 모두 move
            for (Ant ant : Ant.getAnts()) {
                ant.move(organismBoard);
            }//Ant 모두 move
            DoodleBug[] doodles1 = new DoodleBug[DoodleBug.getDoodleBugs().size()];
            int i = 0;
            for (DoodleBug doodle : DoodleBug.getDoodleBugs()) {
                doodles1[i++] = doodle;
            }
            for(int j=0; j < doodles1.length; j++){
                doodles1[j].breed(organismBoard);
            }
            //DoodleBug breed
            i = 0;
            DoodleBug[] doodles2 = new DoodleBug[DoodleBug.getDoodleBugs().size()];
            for (DoodleBug doodle : DoodleBug.getDoodleBugs()) {
                doodles2[i++] = doodle;
            }
            for(int j=0; j < doodles2.length; j++){
                doodles2[j].starve(organismBoard);
            }
            Ant[] ants = new Ant[Ant.getAnts().size()];
            i = 0;
            for (Ant ant : Ant.getAnts()) {
                ants[i++] = ant;
            }//Ant breed*/ant.breed(organismBoard);
            for(int j=0; j < ants.length; j++){
                ants[j].breed(organismBoard);
            }
        }
    }
}
