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
        String check, str;
        StringTokenizer st;
        Cargo cargo = null;
        Warehouse warehouse;
        Truck truck;
        int totalEvent = in.nextInt();
        while (totalEvent > 0) {
            check = in.next();
            int a;
            if(isPositiveInteger(check)) {
                a = Integer.parseInt(check);
            }else continue;
            switch (a) {
                case 1://create a cargo
                    String str1 = in.nextLine();
                    st = new StringTokenizer(str1);//TODO:앞에 공백이 남아있다면 trim()을 써보자
                    check = st.nextToken();
                    int wareId;
                    if(isPositiveInteger(check)) {
                        wareId = Integer.parseInt(check);
                    }else {
                        System.out.println("break");
                        break;
                    }
                    System.out.println(wareId);
                    if (Warehouse.findWarehouseByID(wareId) == null) {//warehouse list에 있는지 없는지 확인
                        break;
                    }
                    if (st.countTokens() == 1) {//무게가 몇인지
                        check = st.nextToken();
                        System.out.println(check);
                        int weight;
                        if(isPositiveInteger(check)) {
                            weight = Integer.parseInt(check);
                        }else break;
                        weight = Integer.parseInt(check);
                        if (weight <= 1000) cargo = new BasicCargo(cargoId++, weight);
                        else cargo = new HeavyCargo(cargoId++, weight);
                    } else if (st.countTokens() == 2) {// 무게가 몇인지, special이 무엇인지
                        check = st.nextToken();
                        int weight;
                        if(isPositiveInteger(check)) {
                            weight = Integer.parseInt(check);
                        }else break;
                        weight = Integer.parseInt(check);
                        String special = st.nextToken();
                        if (special.equals("D")) cargo = new DangerousCargo(cargoId++, weight);
                        else if (special.equals("L")) cargo = new LiquidCargo(cargoId++, weight);
                        else break;//D, L 말고 다른 것이 들어온 경우
                    } else { //input개수가 넘어갈 경우
                        break;
                    }
                    warehouse = Warehouse.findWarehouseByID(wareId);
                    cargo.setCurrentWarehouse(warehouse);
                    warehouse.addCargo(cargo);
                    break;//case 1 종료
                case 2://create a truck
                    try {
                        str = in.nextLine();
                        st = new StringTokenizer(str);
                        int truckLocationID = Integer.parseInt(st.nextToken());
                        warehouse = Warehouse.findWarehouseByID(truckLocationID);
                        if (warehouse == null) {//해당 warehouse가 없는 경우
                            break;
                        }
                        warehouse.incomingTruck(new Truck(truckId++, warehouse, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken())));
                    }catch(Exception e){}//데이터 타입이 안맞을 때
                    break;//TODO: input 오류 관리
                case 3: //create a warehouse
                    try {
                        str = in.nextLine();
                        st = new StringTokenizer(str);
                        double x = Double.parseDouble(st.nextToken());
                        double y = Double.parseDouble(st.nextToken());
                        warehouses.add(new Warehouse(warehouseId++, x, y));
                    } catch (Exception e) {}
                    break;
                case 4:
                    try {
                        str = in.nextLine();
                        st = new StringTokenizer(str);
                        int truckLoadID = Integer.parseInt(st.nextToken());
                        int cargoLoadID = Integer.parseInt(st.nextToken());
                        truck = Truck.findTruckByID(truckLoadID);
                        cargo = Cargo.findCargoByID(cargoLoadID);//예외 상황에는 document에 따라 아무것도 안한다.
                        if (truck != null && cargo != null) truck.load(cargo);
                    } catch (Exception e) {}
                    break;
                case 5:
                    try {
                        int truckUnloadID = in.nextInt();
                        int cargoUnloadID = in.nextInt();
                        truck = Truck.findTruckByID(truckUnloadID);
                        cargo = Cargo.findCargoByID(cargoUnloadID);
                        if (truck != null && cargo != null) truck.unload(cargo);
                    } catch (Exception e) {}
                    break;
                case 6:
                    try {
                        int truckMoveID = in.nextInt();
                        int warehouseMoveID = in.nextInt();
                        truck = Truck.findTruckByID(truckMoveID);
                        warehouse = Warehouse.findWarehouseByID(warehouseMoveID);
                        if (truck != null && warehouse != null) truck.sailTo(warehouse);
                    } catch (Exception e) {}
                    break;
                case 7:
                    try {
                        int truckFuelID = in.nextInt();//이것도 위에서 변수 미리 선언해주는게 낫겠다
                        double fuelAmount = in.nextDouble();
                        truck = Truck.findTruckByID(truckFuelID);
                        if (truck != null) truck.reFuel(fuelAmount);//truck이 없는 경우, 아무것도 안하겠다
                    } catch (Exception e) {}
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
    public static boolean isPositiveInteger(String s) {
        try {
            int a = Integer.parseInt(s);
            if(a < 0) return false;
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public static boolean isPositiveDouble(String s) {
        try {
            if(Double.parseDouble(s)>0) return true;
            else return false;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}