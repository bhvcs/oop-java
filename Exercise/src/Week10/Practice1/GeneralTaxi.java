package Week10.Practice1;

public class GeneralTaxi extends Taxi {
    private double farePerKilometer;
    private double baseDistance = 3;
    private double baseFee = 3;
    GeneralTaxi(int carNum, double ratePerKilometer){
        super(carNum);
        if(ratePerKilometer > baseFee / baseDistance){
            farePerKilometer = ratePerKilometer;
        }
    }

    @Override
    public String toString() {
        return "GeneralTaxi{" + super.toString() +
                " farePerKilometer=" + farePerKilometer +
                ", baseDistance=" + baseDistance +
                ", baseFee=" + baseFee +
                '}';
    }

    @Override
    public double getPaid(double distance) {
        if(distance <= baseDistance){
            return baseFee;
        }
        return baseFee + (distance - baseDistance) * farePerKilometer;
    }

}
