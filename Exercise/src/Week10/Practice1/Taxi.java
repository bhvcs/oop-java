package Week10.Practice1;

public abstract class Taxi {
    int carNum;
    double distance;
    double income;

    public Taxi(int carNum) {
        this.carNum = carNum;
        this.distance = 0;
        this.income = 0;
    }

    public abstract double getPaid(double distance);


    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double doDrive(double dis){
        distance += dis;
        return (income += getPaid(dis));
    }
    public boolean earnMore(Taxi t){
        return income > t.income ? true : false;
    }

    @Override
    public String toString() {
        return "carNum=" + carNum +
                ", distance=" + distance +
                ", income=" + income;
    }
}
