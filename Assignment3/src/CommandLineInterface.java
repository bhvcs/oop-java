import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineInterface {
    private Scanner scanner;

    public CommandLineInterface() {
        this.scanner = new Scanner(System.in);
    }

    public int getMainMenu() throws MenuChoiceException{
        System.out.println("----<Main Menu>----");
        System.out.println("1. Set size of total contacts");
        System.out.println("2. Save the current contact to a file");
        System.out.println("3. Load the saved contact file");
        System.out.println("4. Register new contact");
        System.out.println("5. Search contact");
        System.out.println("6. Delete contact");
        System.out.println("7. Edit contact");
        System.out.println("8. View All Contacts");
        System.out.println("9. Exit");
        System.out.print("Select: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        }catch(InputMismatchException e){
            throw new MenuChoiceException("choice should be integer");
        }
    }

    public int getSetSizeMenu(int prevSize) throws Exception {
        System.out.print("Set size of contact storage (integer or Inf=0): ");
        String tmp = scanner.nextLine();
        int size;
        try{
            size = Integer.parseInt(tmp);
        }catch(Exception e){
            throw new Exception("Size should be integer or Inf");
        }
        if(size == 0) size = -1;
        if(size == -1 && prevSize > -1) System.out.println("size change to infinity");
        else if(size <= prevSize || prevSize <= -1) throw new Exception("please set size bigger than current size");
        else System.out.printf("size change to %d\n", size);
        return size;
    }
    public String[] getCreateContactMenu() throws Exception{
        System.out.println("Create contact...");
        System.out.println("1. normal contact");
        System.out.println("2. club contact");
        System.out.println("3. department contact");
        System.out.print("Select: ");

        int choice = Integer.parseInt(scanner.nextLine());//int형 잘 못쓰는거
        if(choice < 1 || choice > 3) throw new MenuChoiceException(choice);
        System.out.print("name: ");
        String name = scanner.nextLine();
        isVariableFormat(name);
        System.out.print("phone_number: ");
        String phone_number = scanner.nextLine();
        isPhoneNumber(phone_number);
        switch (choice) {
            case 1:
                System.out.print("relation: ");
                break;
            case 2:
                System.out.print("club: ");
                break;
            case 3:
                System.out.print("department: ");
                break;
        }
        String special = scanner.nextLine();
        isVariableFormat(special);
        return new String[]{Integer.toString(choice), name, phone_number, special};
    }
    public String[] getSearchContactMenu() throws Exception{
        System.out.println("Search contact...\nChoose the variable");
        return getVariableInput();
    }
    public String[] getDeleteContactMenu() throws Exception{
        System.out.println("Delete contact...");
        return getSearchContactMenu();
    }
    public String[] getEditContactMenu() throws Exception{
        System.out.println("Edit contact...");
        String[] searchInfo = getSearchContactMenu();
        String[] editInfo = getVariableInput();
        return new String[]{searchInfo[0], searchInfo[1], editInfo[0], editInfo[1]};
    }
    public String[] getVariableInput() throws Exception{
        String[] option = {"name", "phone number", "relation", "club name", "department"};//이걸 잘 활용해보자
        for(int i = 0; i < 5; i++){
            System.out.printf("%d. %s\n", i+1, option[i]);
        }System.out.print("Select: ");

        int choice = Integer.parseInt(scanner.nextLine());
        if(choice < 1 || choice > 5) throw new MenuChoiceException(choice);
        String variable;
        System.out.print(option[choice-1] + ": ");
        variable = scanner.nextLine();
        if(choice == 2) isPhoneNumber(variable);
        else isVariableFormat(variable);
        return new String[]{Integer.toString(choice), variable};
    }
    public void printContactInfo(ArrayList<String>[] contactList){
        int i;
        if(!contactList[0].isEmpty()) System.out.println("Normal Contacts");
        for(i = 0; i < contactList[0].size(); i++){//Normal
            System.out.printf("\t%d. name: %s / phone number: %s / relation: %s\n", i / 3 + 1, contactList[0].get(i), contactList[0].get(++i), contactList[0].get(++i));
        }
        if(!contactList[1].isEmpty()) System.out.println("Club Contacts");
        for(i = 0; i < contactList[1].size(); i++){//Normal
            System.out.printf("\t%d. name: %s / phone number: %s / club name: %s\n", i / 3 + 1, contactList[1].get(i), contactList[1].get(++i), contactList[1].get(++i));
        }
        if(!contactList[2].isEmpty()) System.out.println("Department Contacts");
        for(i = 0; i < contactList[2].size(); i++){//Normal
            System.out.printf("\t%d. name: %s / phone number: %s / department: %s\n", i / 3 + 1, contactList[2].get(i), contactList[2].get(++i), contactList[2].get(++i));
        }
    }
    public void printContact(String ct){
        System.out.println(ct);
    }
    public void printToFile(String[] allInfo) throws FileNotFoundException {
        PrintWriter outputStream = new PrintWriter(new FileOutputStream("ContactBook.txt"));
        for(int i = 0; i < allInfo.length; i++){
            outputStream.println(allInfo[i]);
        }
        outputStream.close();
    }
    public ArrayList<String> scanInFile() throws IOException {
        ArrayList<String> infoInFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("ContactBook.txt"));
        String text = reader.readLine();
        while(text != null) {
            infoInFile.add(text);
            text = reader.readLine();
        }
        return infoInFile;
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }
    private void isVariableFormat(String var) throws MenuChoiceException{
        if(var.length() < 3 || var.length() > 20) throw new MenuChoiceException("length should be greater than 2, lower than 21");
    }
    private void isPhoneNumber(String phoneNum) throws MenuChoiceException{
        if(phoneNum.length() != 13) throw new MenuChoiceException("phone number should follow 010-xxxx-xxxx format");
        if(phoneNum.substring(0, 4).equals("010-") && phoneNum.substring(8,9).equals("-")) return;
        throw new MenuChoiceException("phone number should follow 010-xxxx-xxxx format");
    }
}
