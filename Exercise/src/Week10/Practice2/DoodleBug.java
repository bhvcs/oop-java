package Week10.Practice2;

import java.util.ArrayList;

public class DoodleBug extends Organism{
    private static ArrayList<DoodleBug> doodleBugs = new ArrayList<>();
    private int leftStarve;
    public DoodleBug(int x, int y) {
        super(x, y);
        leftStarve = 3;//TODO
        doodleBugs.add(this);
    }

    public static ArrayList<DoodleBug> getDoodleBugs() {
        return doodleBugs;
    }

    @Override
    public void move(Organism[][] organismBoard) {
        if(getY()-1 >= 0 && organismBoard[getY()-1][getX()] instanceof Ant){
            Ant.getAnts().remove(organismBoard[getY()-1][getX()]);
            organismBoard[getY()][getX()] = null;
            organismBoard[getY()-1][getX()] = this;
            setY(getY()-1);
            leftStarve = 3;//먹었으니 refresh
        }else if(getY()+1 < 10 && organismBoard[getY()+1][getX()] instanceof Ant){
            Ant.getAnts().remove(organismBoard[getY()+1][getX()]);
            organismBoard[getY()][getX()] = null;
            organismBoard[getY()+1][getX()] = this;
            setY(getY()+1);
            leftStarve = 3;//먹었으니 refresh
        }else if(getX()-1 >= 0 && organismBoard[getY()][getX()-1] instanceof Ant){
            Ant.getAnts().remove(organismBoard[getY()][getX()-1]);
            organismBoard[getY()][getX()] = null;
            organismBoard[getY()][getX()-1] = this;
            setX(getX()-1);
            leftStarve = 3;//먹었으니 refresh
        }else if(getX()+1 < 10 && organismBoard[getY()][getX()+1] instanceof Ant){
            Ant.getAnts().remove(organismBoard[getY()][getX()+1]);
            organismBoard[getY()][getX()] = null;
            organismBoard[getY()][getX()+1] = this;
            setX(getX()+1);
            leftStarve = 3;//먹었으니 refresh
        }else {
            super.move(organismBoard);
            leftStarve--;
            return;
        }
        setSurvive(getSurvive()+1);
    }

    public void breed(Organism[][] organismBoard){
        if(getSurvive() == 8){
            if(getY()-1 >= 0 && organismBoard[getY()-1][getX()] == null){
                organismBoard[getY()-1][getX()] = new DoodleBug(getX(), getY()-1);
            }else if(getY()+1 < 10 &&organismBoard[getY()+1][getX()] == null){
                organismBoard[getY()+1][getX()] = new DoodleBug(getX(), getY()+1);
            }else if(getX()-1 >= 0 && organismBoard[getY()][getX()-1] == null){
                organismBoard[getY()][getX()-1] = new DoodleBug(getX()-1, getY());
            }else if(getX()+1 < 10 && organismBoard[getY()][getX()+1] == null){
                organismBoard[getY()][getX()+1] = new DoodleBug(getX()+1, getY());
            }
            setSurvive(0);
        }
    }

    public void starve(Organism[][] organismBoard){
        if(leftStarve == 0){
            doodleBugs.remove(this);
            organismBoard[getY()][getX()] = null;
        }
    }
}
