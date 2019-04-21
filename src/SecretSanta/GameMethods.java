package SecretSanta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameMethods {

    public static void enterData(List<Person> personsPlaying) {
//        System.out.println("How many persons are playing this game? ");
//        Scanner peepsPlaying = new Scanner(System.in);
//        int noOfPeepsPlaying = peepsPlaying.nextInt();
//        if (noOfPeepsPlaying < 3) {
//            System.out.println("Atleast 3 person must play this Secret Santa game, returning to main menu");
//            return;
//        }
//        for (int i = 0; i < noOfPeepsPlaying; i++) {
//            System.out.println("Enter name for person " + (i+1));
//            Scanner personNameScanner = new Scanner(System.in);
//            String personName = personNameScanner.nextLine();
//            personsPlaying.add(new Person(personName));
//        }

        Person Dennis = new Person("Dennis");
        Person Oishi = new Person("Oishi");
        Person Rahul = new Person("Rahul");
        Person Sharu = new Person("Sharon");
        Person Omi = new Person("Rita");
        Person James = new Person("James");

        personsPlaying.add(Dennis);
        personsPlaying.add(Oishi);
        personsPlaying.add(Rahul);
        personsPlaying.add(Sharu);
        personsPlaying.add(Omi);
        personsPlaying.add(James);

        Dennis.setExclusions("Oishi");
        Dennis.setExclusions("Sharu");
        Oishi.setExclusions("Dennis");
        Oishi.setExclusions("Omi");
        Sharu.setExclusions("Dennis");
        Omi.setExclusions("Oishi");


    }

    public static void addPerson(List<Person> personsPlaying) {
        System.out.println("");
        System.out.println("Enter the name of person to add");
        Scanner addPersonScanner = new Scanner(System.in);
        String addPerson = addPersonScanner.nextLine();

        for (Person eachPerson : personsPlaying) {
            if(eachPerson.getName().equalsIgnoreCase(addPerson)) {
                System.out.println(addPerson + " is already on the list, hence cannot add");
                return;
            }
        }
        personsPlaying.add(new Person(addPerson));
    }

    public static void removePerson(List<Person> personsPlaying) {
        System.out.println("");
        System.out.println("Enter the name of person to remove");
        Scanner addPersonScanner = new Scanner(System.in);
        String addPerson = addPersonScanner.nextLine();

        for (Person eachPerson : personsPlaying) {
            if(!eachPerson.getName().equalsIgnoreCase(addPerson)) {
                System.out.println(addPerson + " is not on the list, hence cannot remove");
                return;
            } else {
                personsPlaying.remove(eachPerson);
            }
        }

    }

    public static void printPersons(List<Person> personsPlaying) {
        System.out.println("");
        if(personsPlaying.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        System.out.println("Person List");
        for (Person eachPerson : personsPlaying) {
            System.out.println(eachPerson.getName());
        }
    }

    public static void playSecretSanta(List<Person> personsPlaying) {

        //Part of Secret Santa Part 3 section
        System.out.println("Do you want to set any exclusions for each person playing this game(Y/N)? ");
        Scanner exclusionConditionScanner = new Scanner(System.in);
        String exclusionsCondition = exclusionConditionScanner.nextLine();
        if (exclusionsCondition.equalsIgnoreCase("Y")) {
            setExclusions(personsPlaying);
        }

        canGiftToPeronsList(personsPlaying);
        System.out.println("Starting game: ");
        System.out.println("");

        playGame(personsPlaying);
        System.out.println("You have to buy gift for " + personsPlaying.get(0).getIsSecrectSantaOf());
        System.out.println("See all Secrest Santa(Y/N)? ");
        Scanner viewAllConditionScanner = new Scanner(System.in);
        String viewAllCondiiton = viewAllConditionScanner.nextLine();
        if (viewAllCondiiton.equalsIgnoreCase("Y")) {
            for (Person eachPerson : personsPlaying) {
                System.out.println(eachPerson.getName() + " is the secrect santa of " + eachPerson.getIsSecrectSantaOf());
            }
        }

    }

    //Part of Secret Santa Part 3 section
    private static void setExclusions(List<Person> personsPlaying) {
        boolean quitExclusions = false;
        for (Person eachPerson : personsPlaying) {
            System.out.println("Exclusions options for " + eachPerson.getName());
            while(!quitExclusions) {
                List<Person> copyOfPersonsPlaying = new ArrayList<>();
                copyOfPersonsPlaying.addAll(personsPlaying);
                System.out.println("0. Quit Exclusions for " + eachPerson.getName());
                for (int i = 0; i < copyOfPersonsPlaying.size(); i++) {
                    if(!eachPerson.getName().equalsIgnoreCase(copyOfPersonsPlaying.get(i).getName())) {
                        System.out.println((i) + ". " + copyOfPersonsPlaying.get(i).getName());
                    }
                }
                System.out.println("");
                Scanner exclusionOptiontScanner = new Scanner(System.in);
                int exclusionOption = exclusionOptiontScanner.nextInt();
                if(exclusionOption == 0) {
                    quitExclusions = true;
                    break;
                }
                eachPerson.setExclusions(copyOfPersonsPlaying.get(exclusionOption).getName());
                System.out.println(copyOfPersonsPlaying.get(exclusionOption).getName() + " has been added as exclusion for " + eachPerson.getName());
                copyOfPersonsPlaying.remove(exclusionOption);
            }
        }
    }

    private static void canGiftToPeronsList(List<Person> personsPlaying) {
        List<Person> copyOfPersonsPlaying = new ArrayList<>();
        copyOfPersonsPlaying.addAll(personsPlaying);
        for (Person eachPerson : personsPlaying) {
            for (Person eachPersonAgain : copyOfPersonsPlaying) {
                if((!eachPerson.getExclusions().contains(eachPersonAgain.getName())) && (!eachPerson.getName().equalsIgnoreCase(eachPersonAgain.getName()))) {
                    eachPerson.setCanGiftToList(eachPersonAgain.getName());
                }
            }
        }
    }

    private static void playGame(List<Person> personsPlaying) {
        String secrectSanta = null;
        for(Person eachPerson : personsPlaying) {
            int randomIndex = ThreadLocalRandom.current().nextInt(eachPerson.getCanGiftToList().size());
            List<String> canGiftTo = eachPerson.getCanGiftToList();
            secrectSanta = canGiftTo.get(randomIndex);
            eachPerson.setIsSecrectSantaOf(secrectSanta);
            for (Person eachPersonAgain : personsPlaying) {
                if(eachPersonAgain.getCanGiftToList().contains(secrectSanta)) {
                    List<String> canGiftToPersons = eachPersonAgain.getCanGiftToList();
                    canGiftToPersons.remove(secrectSanta);
                }
            }
        }
    }
}
