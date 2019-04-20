package SecretSanta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner menuOptionScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Secret Santa Game: ");
        boolean quit = false;
        printMainMenu();

        while(!quit) {
            printMainMenu();
            Scanner menuOptionScanner = new Scanner(System.in);
            int menuOption = menuOptionScanner.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.println("How many persons are playing this game:? ");
                    Scanner peepsPlaying = new Scanner(System.in);
                    int noOfPeepsPalying = peepsPlaying.nextInt();
                    List<Person> personPlaying = new ArrayList<>();
                    // total of 9 people playing

                    for(int i = 0; i < noOfPeepsPalying; i++) {
                        System.out.println("Enter name for person " + i);
                        Scanner personScanner = new Scanner(System.in);
                        String person = personScanner.nextLine();
                        personPlaying.add(new Person(person));
                    }

                    //Part of Secret Santa Part 3 section
                    setImmediateFamilyMembers(personPlaying);
                    break;
                case 2:
                    quit = true;
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("1. Play ");
        System.out.println("2. Quit ");
        System.out.print("Enter Option: ");
    }

    private static void setImmediateFamilyMembers(List<Person> personPlaying) {
        System.out.println("Let's enter immediate family members of the list of people entered");
        for(Person eachPerson : personPlaying) {
            System.out.println("Does " + eachPerson.getName() + " have an immediate family member(Y/N)? ");
            Scanner immediateFamilyConditionScanner = new Scanner(System.in);
            String immediateFamilyCondition = immediateFamilyConditionScanner.nextLine();
            if(immediateFamilyCondition.equalsIgnoreCase("Y")) {
                break;
            } else {
                System.out.println("How many immediate family member does " +  eachPerson.getName() + " have? ");
                Scanner immediateFamilyCounterScanner = new Scanner(System.in);
                eachPerson.setNumberOfImmediateFamilyMembers(immediateFamilyCounterScanner.nextInt());
                for(int i = 0; i < eachPerson.getNumberOfImmediateFamilyMembers(); i++) {
                    System.out.println("Enter the name for immediate family member ");
                    Scanner immediateFamilyMemberScanner = new Scanner(System.in);
                    String immediateFamilyMember = immediateFamilyConditionScanner.nextLine();
                    eachPerson.setImmediateFamilyMembers(immediateFamilyMember);
                }
            }
        }
    }

}
