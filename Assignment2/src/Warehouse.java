import java.util.ArrayList;
import java.util.Collections;

public class Warehouse {
    private int ID;
    private double X,Y;
    private ArrayList<Cargo> cargoes = new ArrayList<>();
    private ArrayList<Truck> history = new ArrayList<>();
    private ArrayList<Truck> current = new ArrayList<>();
    private static ArrayList<Warehouse> totalWarehouses = new ArrayList<>();
    public Warehouse(int ID, double x, double y) {
        this.ID = ID;
        X = x;
        Y = y;
        totalWarehouses.add(this);
    }

    public int getID() {
        return ID;
    }

    public static Warehouse findWarehouseByID(int id){
        for(Warehouse wh : totalWarehouses){
            if(wh.getID() == id) return wh;
        }return null;//못 찾은 경우
    }

    public ArrayList<Cargo> getCargoes() { return cargoes; }

    public void addCargo(Cargo c) { cargoes.add(c); }

    public void removeCargo(Cargo c){ cargoes.remove(c); }

    public void incomingTruck(Truck t){
        current.add(t);
    }

    public void outgoingTruck(Truck t){
        current.remove(t);
        history.add(t);
    }
    public double getDistance(Warehouse other){
        double dX = X - other.X;
        double dY = Y - other.Y;
        return Math.sqrt((dX * dX) + (dY * dY));
    }
    public String toString(){
        String format = String.format("Warehouse %d: (%.1f, %.1f)\n", ID, X, Y);
        for(String str : Cargo.formattingCargoes((cargoes))){
            format += String.format("  %s", str);
        }
        Collections.sort(current, ((o1, o2) -> o1.getID() - o2.getID()));
        for(Truck t : current){
            format += t.formattingTruck();
        }
        return format;
    }
}
