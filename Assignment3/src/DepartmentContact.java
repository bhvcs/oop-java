public class DepartmentContact extends ContactInfo{
    private String department;
    public DepartmentContact(String name, String phone_number, String department) {
        super(name, phone_number);
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getInfo() {
        return String.format("DepartmentContact %s %s %s", getName(), getPhone_number(), getDepartment());
    }

    @Override
    public String toString() {
        return String.format("name: %s / phone number: %s / department: %s", getName(), getPhone_number(), getDepartment());
    }
}
