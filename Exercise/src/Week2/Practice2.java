package Week2;

public class Practice2 {
    public static void main(String[] args){
        String input = "Walt Savitch";
        String output = null;

        int index = input.indexOf(" ");

        char ch1 = input.charAt(0);
        char ch2 = input.charAt(1);
        String str1 = input.substring(2, index);
        char ch3 = input.charAt(index+1);
        char ch4 = input.charAt(index+2);
        String str2 = input.substring(index+3);

        output = Character.toUpperCase(ch2) + str1 + Character.toLowerCase(ch1) + "ay "
                + Character.toUpperCase(ch4) + str2 + Character.toLowerCase(ch3) + "ay";

        System.out.println(output);
    }
}
