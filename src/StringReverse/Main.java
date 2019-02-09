package StringReverse;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the String ");
        String string = scanner.nextLine();

        System.out.println("Entered string is: " + string);
        string = reverseString(string);
        System.out.println("Reversed string is: " + string);

    }


    public static String reverseString(String passedString) {
        StringBuffer sb = new StringBuffer("");
        char[] chars = passedString.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return String.valueOf(sb);
    }

}
