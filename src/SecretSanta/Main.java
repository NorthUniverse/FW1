package SecretSanta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static Scanner menuOptionScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Secret Santa Game: ");
        boolean quit = false;

        while(!quit) {
            try {
                printMainMenu();
                Scanner menuOptionScanner = new Scanner(System.in);
                int menuOption = menuOptionScanner.nextInt();
                switch (menuOption) {
                    case 1:
                        GameMethods.play();
                        break;
                    case 2:
                        System.out.println("Ending game");
                        quit = true;
                        break;
                    default:
                        System.out.println("Unknown option entered, ending game");
                        quit = true;
                        break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Wrong input, please enter option 1 or 2: ");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("1. Play Secrect Santa");
        System.out.println("2. Quit ");
        System.out.print("Enter Option: ");
    }
}
