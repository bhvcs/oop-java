import java.util.ArrayList;
import java.util.Collections;

public class Truck {
    private final int ID;
    private double fuel;
    private Warehouse currentWarehouse;
    private final int totalWeight;
    private final int maxNumOfAllCargoes;
    private final int maxNumOfHeavyCargoes;
    private final int maxNumOfDangerousCargoes;
    private final int maxNumOfLiquidCargoes;
    private int currentWeight;
    private int currentNumOfAllCargoes;
    private int currentNumOfHeavyCargoes;
    private int currentNumOfDangerousCargoes;
    private int currentNumOfLiquidCargoes;
    private double fuelPerKm;
    private static ArrayList<Truck> totalTrucks = new ArrayList<>();
    private ArrayList<Cargo> currentCargoes = new ArrayList<>();

    public Truck(int ID, Warehouse w, int totalWeight, int maxNumOfAllCargoes, int maxNumOfHeavyCargoes, int maxNumOfDangerousCargoes,
                 int maxNumOfLiquidCargoes, double fuelPerKm) {
        this.ID = ID;
        this.currentWarehouse = w;
        this.totalWeight = totalWeight;
        this.maxNumOfAllCargoes = maxNumOfAllCargoes;
        this.maxNumOfHeavyCargoes = maxNumOfHeavyCargoes;
        this.maxNumOfDangerousCargoes = maxNumOfDangerousCargoes;
        this.maxNumOfLiquidCargoes = maxNumOfLiquidCargoes;
        this.fuelPerKm = fuelPerKm;
        totalTrucks.add(this);
    }
    public static Truck findTruckByID(int id){
        for(Truck t : totalTrucks){
            if(t.getID() == id) return t;
        }return null;//못 찾은 경우
    }

    public int getID() {
        return ID;
    }

    public ArrayList<Cargo> getCurrentCargoes() {
        Collections.sort(currentCargoes, (o1, o2) -> o1.getID() - o2.getID());
        ArrayList<Cargo> sortedCurrentCargoes = new ArrayList<>();
        for (Cargo c : currentCargoes){
            sortedCurrentCargoes.add(c);
        }
        return sortedCurrentCargoes;
    }

    public boolean load(Cargo c) {
        if(!currentWarehouse.getCargoes().contains(c)) return false; //트럭이 있는 곳에 짐이 없을 경우
        if (currentWeight + c.getWeight() <= totalWeight) {
            if (c instanceof LiquidCargo && currentNumOfLiquidCargoes + 1 <= maxNumOfLiquidCargoes && currentNumOfAllCargoes + 1 <= maxNumOfAllCargoes) {
                currentNumOfLiquidCargoes++;
            } else if (c instanceof DangerousCargo && currentNumOfDangerousCargoes + 1 <= maxNumOfDangerousCargoes && currentNumOfAllCargoes + 1 <= maxNumOfAllCargoes) {
                currentNumOfDangerousCargoes++;
            } else if (c instanceof HeavyCargo && currentNumOfHeavyCargoes + 1 <= maxNumOfHeavyCargoes && currentNumOfAllCargoes + 1 <= maxNumOfAllCargoes) {
                currentNumOfHeavyCargoes++;
            } else if (c instanceof BasicCargo && currentNumOfAllCargoes + 1 <= maxNumOfAllCargoes);//일부러 빼놓음
            else return false; //총 짐 개수가 넘어가는 경우
        } else return false;//무게가 초과하는 경우
        currentNumOfAllCargoes++;//어차피 예외인 애들은 위에서 false로 return 됐을 것이기에 여기에 썼다.
        currentWeight += c.getWeight();
        currentCargoes.add(c);
        currentWarehouse.removeCargo(c);
        return true;
    }
    public boolean unload(Cargo c){
        if(!currentCargoes.contains(c)) return false;//트럭에 짐이 없는 경우
        if (c instanceof LiquidCargo) {
            currentNumOfLiquidCargoes--;
        } else if (c instanceof DangerousCargo) {
            currentNumOfDangerousCargoes--;
        } else if (c instanceof HeavyCargo) {
            currentNumOfHeavyCargoes--;
        }//else 여기선 예외 관리 필요 없음<-unload는 어차피 있는거에서 빼는거니 else는 굳이?
        currentNumOfAllCargoes--;
        currentWeight -= c.getWeight();
        currentCargoes.remove(c);
        currentWarehouse.addCargo(c);
        return true;
    }

    public boolean sailTo(Warehouse w) {
        if(currentWarehouse.equals(w)) return false;
        double consume = 0;
        for(Cargo c : currentCargoes){//Truck에 있는 cargo 총 consumtion
            consume += c.consumption();
        }//System.out.println("수화물 소비량: " + consume);
        consume = (consume + fuelPerKm) * currentWarehouse.getDistance(w);
        if(consume <= fuel){
            w.incomingTruck(this);
            currentWarehouse.outgoingTruck(this);
            fuel -= consume;
            currentWarehouse = w;
            return true;
        }
        return false;//fuel이 부족한 경우
    }
    public void reFuel(double amount){
        fuel += amount;
    }
    public String formattingTruck(){
        String format = String.format("  Truck %d: %.1f\n", ID, fuel);
        for(String str : Cargo.formattingCargoes((getCurrentCargoes()))){
            format += String.format("\t%s", str);
        }
        return format;
    }

}

