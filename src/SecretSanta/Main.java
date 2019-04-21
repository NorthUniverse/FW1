package SecretSanta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner menuOptionScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Secret Santa Game: ");
        boolean quit = false;
        List<Person> personsPlaying = new ArrayList<>();
        int gameCounter = 1;

        while (!quit) {
            try {
                printMainMenu();
                Scanner menuOptionScanner = new Scanner(System.in);
                int menuOption = menuOptionScanner.nextInt();
                switch (menuOption) {
                    case 1:
                        GameMethods.enterData(personsPlaying);
                        break;
                    case 2:
                        GameMethods.addPerson(personsPlaying);
                        break;
                    case 3:
                        GameMethods.removePerson(personsPlaying);
                        break;
                    case 4:
                        GameMethods.printPersons(personsPlaying);
                        break;
                    case 5:
                        GameMethods.setExclusions(personsPlaying);
                        break;
                    case 6:
                        GameMethods.playSecretSanta(personsPlaying, gameCounter);
                        break;
                    case 7:
                        System.out.println("Ending game");
                        quit = true;
                        break;
                    default:
                        System.out.println("Unknown option entered, ending game");
                        quit = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong datatype for input");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Enter Initial Person Data");
        System.out.println("2. Add a new person");
        System.out.println("3. Remove a person");
        System.out.println("4. Print person list");
        System.out.println("5. Set Exclusions");
        System.out.println("6. Play Secret Santa");
        System.out.println("7. Quit ");
        System.out.print("Enter Option: ");
    }
}
