public abstract class ContactInfo {
    private String name;
    private String phone_number;

    public ContactInfo(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public abstract String getInfo();//String이 아닐 수도 있음
    public abstract String toString();
}
