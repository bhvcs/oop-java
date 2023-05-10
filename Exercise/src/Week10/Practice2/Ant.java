package Week10.Practice2;

import java.util.ArrayList;

public class Ant extends Organism{
    private static ArrayList<Ant> ants = new ArrayList<>();
    public Ant(int x, int y) {
        super(x, y);
        ants.add(this);
    }
    /*public static Ant findAnt(int x, int y){
        for(Ant a : ants){
            if(a.getX() == x && a.getY() == y) return a;
        }
        return null;
    }*/
    public static ArrayList<Ant> getAnts() {
        return ants;
    }

    @Override
    public void move(Organism[][] organismBoard) {
        super.move(organismBoard);
    }

    public void breed(Organism[][] organismBoard){
        if(getSurvive() == 3){
            if(getY()-1 >= 0 && organismBoard[getY()-1][getX()] == null){
                organismBoard[getY()-1][getX()] = new Ant(getX(), getY()-1);
            }else if(getY()+1 < 10 && organismBoard[getY()+1][getX()] == null){
                organismBoard[getY()+1][getX()] = new Ant(getX(), getY()+1);
            }else if(getX()-1 >= 0 && organismBoard[getY()][getX()-1] == null){
                organismBoard[getY()][getX()-1] = new Ant(getX()-1, getY());
            }else if(getX()+1 < 10 && organismBoard[getY()][getX()+1] == null){
                organismBoard[getY()][getX()+1] = new Ant(getX()+1, getY());
            }
            setSurvive(0);
        }
    }
}
