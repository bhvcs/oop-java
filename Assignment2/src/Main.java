import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {//TODO: privacy leak 확인, 일단 scanner에 공백은 신경안쓰고 했다
    public static void main(String[] args) throws FileNotFoundException{
        int warehouseId = 0, truckId = 0, cargoId = 0;
        ArrayList<Warehouse> warehouses = new ArrayList<>();
        Scanner in = new Scanner(new File(args[0]));
        PrintStream out = new PrintStream(new File(args[1]));

        StringTokenizer st;
        Cargo cargo = null;
        Warehouse warehouse;
        Truck truck;
        int totalEvent = in.nextInt();//\n 조심
        while(totalEvent > 0){
            switch(in.nextInt()){
                case 1://create a cargo
                    //String junk = sc.nextLine();
                    String str1 = in.nextLine();
                    st = new StringTokenizer(str1);//TODO:앞에 공백이 남아있다면 trim()을 써보자
                    int wareId = Integer.parseInt(st.nextToken());

                    if(Warehouse.findWarehouseByID(wareId) == null){//warehouse list에 있는지 없는지 확인
                        break;
                    }
                    if(st.countTokens() == 1){//무게가 몇인지
                        int weight = Integer.parseInt(st.nextToken());
                        if( weight <= 1000) cargo = new BasicCargo(cargoId++, weight);
                        else cargo = new HeavyCargo(cargoId++, weight);
                    }else if(st.countTokens() == 2){// 무게가 몇인지, special이 무엇인지
                        int weight = Integer.parseInt(st.nextToken());
                        String special = st.nextToken();
                        if(special.equals("D")) cargo = new DangerousCargo(cargoId++, weight);
                        else if(special.equals("L")) cargo = new LiquidCargo(cargoId++, weight);
                        else break;//D, L 말고 다른 것이 들어온 경우
                    }else { //input이 넘어갈 경우
                        break;
                    }
                    warehouse = Warehouse.findWarehouseByID(wareId);
                    cargo.setCurrentWarehouse(warehouse);
                    warehouse.addCargo(cargo);
                    break;//case 1 종료

                case 2://create a truck
                    String str2 = in.nextLine();
                    st = new StringTokenizer(str2);
                    int truckLocationID = Integer.parseInt(st.nextToken());
                    warehouse = Warehouse.findWarehouseByID(truckLocationID);
                    if(warehouse == null){//해당 warehouse가 없는 경우
                        break;
                    }
                    warehouse.incomingTruck(new Truck(truckId++, warehouse, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken())));
                    break;//TODO: input 오류 관리
                case 3: //create a warehouse
                    Double x = in.nextDouble();
                    Double y = in.nextDouble();
                    warehouses.add(new Warehouse(warehouseId++, x, y));
                    break;
                case 4:
                    int truckLoadID = in.nextInt();
                    int cargoLoadID = in.nextInt();
                    truck = Truck.findTruckByID(truckLoadID);
                    cargo = Cargo.findCargoByID(cargoLoadID);//예외 상황에는 document에 따라 아무것도 안한다.
                    if(truck != null && cargo != null) truck.load(cargo);
                    break;
                case 5:
                    int truckUnloadID = in.nextInt();
                    int cargoUnloadID = in.nextInt();
                    truck = Truck.findTruckByID(truckUnloadID);
                    cargo = Cargo.findCargoByID(cargoUnloadID);
                    if(truck != null && cargo != null) truck.unload(cargo);
                    break;
                case 6:
                    int truckMoveID = in.nextInt();
                    int warehouseMoveID = in.nextInt();
                    truck = Truck.findTruckByID(truckMoveID);
                    warehouse = Warehouse.findWarehouseByID(warehouseMoveID);
                    if(truck != null && warehouse != null) truck.sailTo(warehouse);
                    break;
                case 7:
                    int truckFuelID = in.nextInt();//이것도 위에서 변수 미리 선언해주는게 낫겠다
                    double fuelAmount = in.nextDouble();
                    truck = Truck.findTruckByID(truckFuelID);
                    if(truck != null) truck.reFuel(fuelAmount);//truck이 없는 경우, 아무것도 안하겠다
                    break;
                default:
                    break;
            }
            totalEvent--;
        }
        for(Warehouse w : warehouses){
            out.print(w.toString());
        }
        in.close();
        out.close();
    }
}