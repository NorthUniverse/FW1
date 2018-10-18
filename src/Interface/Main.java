package Interface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner menuScanner = new Scanner(System.in);
        boolean quit = false;
        Scanner dataScanner = new Scanner(System.in);
        Saveable saveable = new Saveable();
        printMenu();

        while(!quit) {

            int menuOption = menuScanner.nextInt();
            switch (menuOption) {
                case 0:
                    System.out.println("Bye bye, now ending program");
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter the String data to add to the array list");
                    String data = dataScanner.nextLine();
                    saveable.inputDataToArrayList(data);
                    break;
                case 2:
                    saveable.printDataFromArrayList();
                    break;
                case 3:
                    String toStringData = saveable.toString();
                    System.out.println(toStringData);
                    break;
                case 4:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid option, ending program");
                    quit = true;
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("0. Quit");
        System.out.println("1. Add String to ArrayList");
        System.out.println("2. Print ArrayList");
        System.out.println("3. Print ArrayList from tostring method");
        System.out.println("4. Print Menu\n");
    }
}
