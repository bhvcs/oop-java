public class NormalContact extends ContactInfo{

    private String relation;
    public NormalContact(String name, String phone_number, String relation) {
        super(name, phone_number);
        this.relation = relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    @Override
    public String getInfo() {
        return String.format("NormalContact %s %s %s", getName(), getPhone_number(), getRelation());
    }

    @Override
    public String toString() {
        return String.format("name: %s / phone number: %s / relation: %s", getName(), getPhone_number(), getRelation());
    }
}
