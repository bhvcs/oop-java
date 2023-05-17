package Week11.Practice2;

public class Account {
    private String ID;
    private int account_num;
    private int balance;

    public Account(String ID, int account_num, int balance) {
        this.ID = ID;
        this.account_num = account_num;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "/ account_num: " + account_num + "/ balance: " + balance;
    }
}
