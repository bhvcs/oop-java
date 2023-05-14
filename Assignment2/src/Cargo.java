import java.util.ArrayList;
import java.util.Collections;

public abstract class Cargo {
    private int ID;
    private int weight;
    private static ArrayList<Cargo> totalCargoes = new ArrayList<>();
    private Warehouse currentWarehouse;

    public Cargo(int ID, int weight) {
        this.ID = ID;
        this.weight = weight;
        totalCargoes.add(this);
    }
    public static Cargo findCargoByID(int id){
        for(Cargo c : totalCargoes){
            if(c.getID() == id) return c;
        }return null;//못 찾은 경우
    }

    public void setCurrentWarehouse(Warehouse currentWarehouse) {
        this.currentWarehouse = currentWarehouse;
    }

    public int getID() {
        return ID;
    }

    public int getWeight() {
        return weight;
    }
    private static ArrayList<Integer>[] categorizeCargo(ArrayList<Cargo> cargoes){
        String type;
        ArrayList<Integer>[] arrayLists = new ArrayList[4];
        for(int i = 0; i < 4; i++){
            arrayLists[i] = new ArrayList<Integer>();
        }
        Collections.sort(cargoes, (((o1, o2) -> o1.getID() - o2.getID())));
        for(Cargo c : cargoes){
            type = c.getType();
            if(type.equals("B")) arrayLists[0].add(c.getID());
            else if(type.equals("H")) arrayLists[1].add(c.getID());
            else if(type.equals("D")) arrayLists[2].add(c.getID());
            else if(type.equals("L")) arrayLists[3].add(c.getID());
        }
        return arrayLists;
    }
    public static ArrayList<String> formattingCargoes(ArrayList<Cargo> cargoes){
        ArrayList<String> formatArr = new ArrayList<>();//시발련아        String str = "";
        ArrayList<Integer>[] arr = categorizeCargo(cargoes);
        for(int i = 0; i < 4; i++){
            if(!arr[i].isEmpty()){//비어 있지 않다면
                //Collections.sort(arr[i]);정렬 위에서 하고 왔으니 할 필요 없음
                String str = "";
                if(i == 0){
                    for(int el : arr[i]){
                        str += String.format(" %d", el);
                    }
                    formatArr.add(String.format("BasicCargo:%s\n", str));
                }else if(i == 1){
                    for(int el : arr[i]){
                        str += String.format(" %d", el);
                    }
                    formatArr.add(String.format("HeavyCargo:%s\n", str));
                }else if(i == 2){
                    for(int el : arr[i]){
                        str += String.format(" %d", el);
                    }
                    formatArr.add(String.format("DangerousCargo:%s\n", str));
                }else if(i == 3){//안전하게
                    for(int el : arr[i]){
                        str += String.format(" %d", el);
                    }
                    formatArr.add(String.format("LiquidCargo:%s\n", str));
                }//아무것도 저장된게 없다고 할 때 어떻게 할지 생각해보자
            }//else continue 비어있다면
        }
        return formatArr;
    }
    public abstract double consumption();
    public abstract String getType();
}
