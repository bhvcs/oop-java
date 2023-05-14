public class HeavyCargo extends Cargo{
    HeavyCargo(int ID, int weight){
        super(ID, weight);
    }
    @Override
    public double consumption() {
        return getWeight() * 2.5;
    }
    @Override
    public String getType() {
        return "H";
    }
}
