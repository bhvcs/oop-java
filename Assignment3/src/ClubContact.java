public class ClubContact extends ContactInfo{
    private String club;
    public ClubContact(String name, String phone_number, String club) {
        super(name, phone_number);
        this.club = club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClub() {
        return club;
    }

    @Override
    public String getInfo() {
        return String.format("ClubContact %s %s %s", getName(), getPhone_number(), getClub());
    }

    @Override
    public String toString() {
        return String.format("name: %s / phone number: %s / club name: %s", getName(), getPhone_number(), getClub());
    }
}
