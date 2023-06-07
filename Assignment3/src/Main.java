import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
        ContactManager manager = new ContactManager(cli);
        int choice;

        while(true) {
            try {
                choice = cli.getMainMenu();
                if(choice < 1 || choice > 9)
                    throw new MenuChoiceException(choice);
                switch(choice)
                {
                    case 1:
                        manager.setStorageSize();
                        break;
                    case 2:
                        manager.saveToFile();
                        break;
                    case 3:
                        manager.loadFromFile();
                        break;
                    case 4:
                        manager.createContact();
                        break;
                    case 5:
                        manager.searchContact();
                        break;
                    case 6:
                        manager.deleteContact();
                        break;
                    case 7:
                        manager.editContact();
                        break;
                    case 8:
                        cli.printContactInfo(manager.provideAllContact());
                        break;
                    case 9:
                        return;
                }
            }
            catch(MenuChoiceException e)
            {
                cli.printErrorMessage(e.getMessage());
            }catch (FileNotFoundException e) {
                cli.printErrorMessage("not found that file");
            }catch(NumberFormatException e){
                cli.printErrorMessage("choice should be integer");
            }
            catch(IOException e){//readline 메서드용
            }
            catch(Exception e){
                cli.printErrorMessage(e.getMessage());
            }
        }
    }
}
/*try
            {
                choice = cli.getMainMenu();
                if(choice < 1 || choice > 9)
                    throw new MenuChoiceException(choice);
                switch(choice)
                {
                    case 1:
                        manager.setStorageSize();
                        break;
                    case 2:
                    manager.saveToFile();
                    break;
                case 3:
                    manager.loadFromFile();
                    break;
                case 4:
                    manager.createContact();
                    break;
                case 5:
                    manager.searchContact();
                    break;
                case 6:
                    manager.deleteContact();
                    break;
                case 7:
                    manager.editContact();
                    break;
                case 8:
                    cli.printContactInfo(manager.provideAllContact());
                    break;
                case 9:
                    return;


                }
            }
            catch(MenuChoiceException e)
            {
                // Your Implementation (using cli's printErrorMessage method)
            }*/