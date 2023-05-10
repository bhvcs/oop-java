package Week10.Practice1;

public class DeluxeTaxi extends Taxi {

    private double farePerKilometer;
    private double baseDistance = 3;
    private double baseFee = 5;

    public DeluxeTaxi(int carNum, double ratePerKilometer) {
        super(carNum);
        if(ratePerKilometer > baseFee / baseDistance) {
            this.farePerKilometer = ratePerKilometer;
        }
    }

    @Override
    public double getPaid(double distance) {
        if(distance <= baseDistance){
            return baseFee;
        }
        return baseFee + (distance - baseDistance) * farePerKilometer;
    }

    @Override
    public String toString() {
        return "DeluxeTaxi{"  + super.toString() +
                " farePerKilometer=" + farePerKilometer +
                ", baseDistance=" + baseDistance +
                ", baseFee=" + baseFee +
                '}';
    }
}
