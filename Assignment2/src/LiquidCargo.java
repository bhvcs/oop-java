public class LiquidCargo extends HeavyCargo{
    LiquidCargo(int ID, int weight) { super(ID, weight); }

    @Override
    public double consumption() { return getWeight() * 3.5; }
    @Override
    public String getType() {
        return "L";
    }
}
