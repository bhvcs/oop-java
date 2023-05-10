package Week10.Practice2;

import java.util.Random;

public class Organism {
    private static int count;
    private int survive;
    private int x;
    private int y;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
        survive = 0;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Organism.count = count;
    }

    public int getSurvive() {
        return survive;
    }

    public void setSurvive(int survive) {
        this.survive = survive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(Organism[][] organismBoard){// 1 2 3 4 -> 상 하 좌 우
        Random rnd = new Random();
        int direction = 0;
        if((x-1<0 || organismBoard[y][x-1] != null) && (x+1 > 9 || organismBoard[y][x+1] != null) && (y-1<0 || organismBoard[y-1][x] != null)
                && (y+1>9 || organismBoard[y+1][x] != null)) return;//전방위 막혔을 때 가만히 있겠다
        while(direction == 0){
            direction = rnd.nextInt(4) + 1;
            switch(direction){
                case 1:
                    if(y-1 >= 0 && organismBoard[y-1][x] == null) {
                        //System.out.println("위");
                        organismBoard[y][x] = null;
                        y -= 1;
                        organismBoard[y][x] = this;
                    }else direction = 0;
                    break;
                case 2:
                    if(y+1 < 10 && organismBoard[y+1][x] == null) {
                        //System.out.println("아래");
                        organismBoard[y][x] = null;
                        y += 1;
                        organismBoard[y][x] = this;
                    }else direction = 0;
                    break;
                case 3:
                    if(x-1 >= 0 && organismBoard[y][x-1] == null) {
                        //System.out.println("왼");
                        organismBoard[y][x] = null;
                        x -= 1;
                        organismBoard[y][x] = this;
                    }else direction = 0;
                    break;
                case 4:
                    if(x+1 < 10 && organismBoard[y][x+1] == null) {
                        //System.out.println("오");
                        organismBoard[y][x] = null;
                        x += 1;
                        organismBoard[y][x] = this;
                    }else direction = 0;
                    break;
            }//네방향 모두 막혀있을 떄 행동
        }
        survive++;
    }
}
