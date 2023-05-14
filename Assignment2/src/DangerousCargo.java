public class DangerousCargo extends HeavyCargo{
    DangerousCargo(int ID, int weight) {
        super(ID, weight);
    }

    @Override
    public double consumption() {
        return getWeight() * 4.0;
    }
    @Override
    public String getType() {
        return "D";
    }
}
