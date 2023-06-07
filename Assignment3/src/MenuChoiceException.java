public class MenuChoiceException extends Exception{
    public MenuChoiceException(){
        super("Menu Choice Exception happens!");
    }

    public MenuChoiceException(String message){
        super(message);
    }
    public MenuChoiceException(int choice){
        super(choice + " is not available");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
