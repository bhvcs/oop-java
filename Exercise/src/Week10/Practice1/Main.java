package Week10.Practice1;

import Week10.Practice1.DeluxeTaxi;
import Week10.Practice1.GeneralTaxi;
import Week10.Practice1.Taxi;

public class Main {
    public static void main(String[] args) {
        Taxi t1 = new GeneralTaxi(1234, 2.1);
        Taxi t2 = new DeluxeTaxi(2345, 6.1);

        System.out.println(t1.toString());//TODO
        System.out.println(t2.toString());//TODO

        t1.doDrive(5.2);
        t1.doDrive(2.4);

        t2.doDrive(5);
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        if(t1.earnMore(t2)){
            System.out.println("t1 earn more than t2");
        }else{
            System.out.println("t2 earn more than t1");
        }
    }
}
