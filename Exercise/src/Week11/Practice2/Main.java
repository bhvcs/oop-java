package Week11.Practice2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Account account;
        Scanner sc = new Scanner(System.in);
        String str;
        String id;
        int account_num, balance;
        StringTokenizer st;
        while(true){
            try {
                str = sc.nextLine();
                st = new StringTokenizer(str);
                id = st.nextToken();
                account_num = Integer.parseInt(st.nextToken());
                balance = Integer.parseInt(st.nextToken());
                if (!Character.isLetter(id.charAt(0))) throw new Exception("ID must start with a letter");
                if(id.length() != 3) throw new Exception("ID should be followed by three digits");
                if(account_num < 10000 || account_num > 99999) throw new Exception("Account number must be of five digits");
                if(balance <= 1000) throw new Exception("Initial balance must be above $1000");
            }catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }
            account = new Account(id, account_num, balance);
            break;
        }
        System.out.println(account.toString());
    }
}
