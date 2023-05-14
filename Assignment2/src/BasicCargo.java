public class BasicCargo extends Cargo{

    BasicCargo(int ID, int weight){ super(ID, weight); }//무개 관리 할 필요 없음. 어차피 main에서 걸려줌
    @Override
    public double consumption() {
        return getWeight() * 1.5;
    }

    @Override
    public String getType() {
        return "B";
    }
}
