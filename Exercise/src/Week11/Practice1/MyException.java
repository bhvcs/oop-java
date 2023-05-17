package Week11.Practice1;


public class MyException extends Exception{
    String solution = "";
    public MyException(){
        super("MyException is occur");
    }
    public MyException(String message, int exceptionCase){
        super(message);
        switch(exceptionCase) {
            case 1: {
                solution = "make a and b to exceed 1";
                break;
            }
            case 2: {
                solution = "make a and b are different";
                break;
            }
            case 3: {
                solution = "make a or b to do not exceed 10000";
                break;
            }
        }
    }

    @Override
    public String getMessage() {
        return "cause: " + super.getMessage() + "\nsolution: " + solution;
    }
}
