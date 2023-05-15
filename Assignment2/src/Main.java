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
        in.nextLine();//개행문자 없애기
        while (totalEvent > 0) {
            int eventcase;
            str = in.nextLine();
            st = new StringTokenizer(str);
            try {
                eventcase = Integer.parseInt(st.nextToken());
            }catch(Exception e){//int가 아닌 string이 오는 것을 걸러내기
                totalEvent--;
                continue;
            }
            switch (eventcase) {
                case 1://create a cargo
                    try {
                        int wareId = Integer.parseInt(st.nextToken());
                        if (Warehouse.findWarehouseByID(wareId) == null) {//warehouse list에 있는지 없는지 확인
                            break;
                        }
                        if (st.countTokens() == 1) {//무게가 몇인지
                            int weight = Integer.parseInt(st.nextToken());
                            if (weight > 0 && weight <= 1000) cargo = new BasicCargo(cargoId++, weight);
                            else if( weight > 1000) cargo = new HeavyCargo(cargoId++, weight);
                            else break;
                        } else if (st.countTokens() == 2) {// 무게가 몇인지, special이 무엇인지
                            int weight = Integer.parseInt(st.nextToken());
                            if(weight <= 0) break;
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
                    }catch(Exception e){}
                    break;//case 1 종료
                case 2://create a truck
                    try {
                        int truckLocationID = Integer.parseInt(st.nextToken());
                        warehouse = Warehouse.findWarehouseByID(truckLocationID);
                        if (warehouse == null) {//해당 warehouse가 없는 경우
                            break;
                        }
                        if(st.countTokens() != 6) break;
                        int[] checks = new int[5];
                        for(int i= 0 ; i < 5; i++){
                            checks[i] = Integer.parseInt(st.nextToken());
                            if(checks[i] < 0) throw new Exception();
                        }
                        double fuelPerKm = Double.parseDouble(st.nextToken());
                        if(fuelPerKm < 0) break;
                        warehouse.incomingTruck(new Truck(truckId++, warehouse, checks[0], checks[1],
                                checks[2], checks[3], checks[4], fuelPerKm));
                    }catch(Exception e){}//데이터 타입이 안맞을 때, 음수일 때
                    break;//TODO: input 오류 관리
                case 3: //create a warehouse
                    try {
                        double x = Double.parseDouble(st.nextToken());
                        double y = Double.parseDouble(st.nextToken());
                        warehouses.add(new Warehouse(warehouseId++, x, y));
                    } catch (Exception e) {}
                    break;
                case 4:
                    try {
                        if(st.countTokens() != 2) break;
                        int truckLoadID = Integer.parseInt(st.nextToken());
                        int cargoLoadID = Integer.parseInt(st.nextToken());
                        truck = Truck.findTruckByID(truckLoadID);
                        cargo = Cargo.findCargoByID(cargoLoadID);//예외 상황에는 document에 따라 아무것도 안한다.
                        if (truck != null && cargo != null) truck.load(cargo);
                    } catch (Exception e) {}
                    break;
                case 5:
                    try {
                        if(st.countTokens() != 2) break;
                        int truckUnloadID = Integer.parseInt(st.nextToken());
                        int cargoUnloadID = Integer.parseInt(st.nextToken());
                        truck = Truck.findTruckByID(truckUnloadID);
                        cargo = Cargo.findCargoByID(cargoUnloadID);
                        if (truck != null && cargo != null) truck.unload(cargo);
                    } catch (Exception e) {}
                    break;
                case 6:
                    try {
                        if(st.countTokens() != 2) break;
                        int truckMoveID = Integer.parseInt(st.nextToken());
                        int warehouseMoveID = Integer.parseInt(st.nextToken());
                        truck = Truck.findTruckByID(truckMoveID);
                        warehouse = Warehouse.findWarehouseByID(warehouseMoveID);
                        if (truck != null && warehouse != null) truck.sailTo(warehouse);
                    } catch (Exception e) {}
                    break;
                case 7:
                    try {
                        if(st.countTokens() != 2) break;
                        int truckFuelID = Integer.parseInt(st.nextToken());//이것도 위에서 변수 미리 선언해주는게 낫겠다
                        double fuelAmount = Double.parseDouble(st.nextToken());
                        if(fuelAmount < 0) break;
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