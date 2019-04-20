package SecretSanta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameMethods {

    public static void play() {
//        System.out.println("How many persons are playing this game? ");
//        Scanner peepsPlaying = new Scanner(System.in);
//        int noOfPeepsPlaying = peepsPlaying.nextInt();
//        if (noOfPeepsPlaying < 3) {
//            System.out.println("Atleast 3 person must play this game, returning to main menu");
//            return;
//        }
        List<Person> personsPlaying = new ArrayList<>();
//
//        for (int i = 0; i < noOfPeepsPlaying; i++) {
//            if(i==0) {
//                System.out.println("Enter your name ");
//            } else {
//                System.out.println("Enter name for person " + (i));
//            }
//            Scanner personScanner = new Scanner(System.in);
//            String person = personScanner.nextLine();
//            personsPlaying.add(new Person(person));
//        }
//        //Part of Secret Santa Part 3 section
//        System.out.println("Do you want to set any exclusions for each person playing this game(Y/N)? ");
//        Scanner exclusionConditionScanner = new Scanner(System.in);
//        String exclusionsCondition = exclusionConditionScanner.nextLine();
//        if (exclusionsCondition.equalsIgnoreCase("Y")) {
//            setExclusions(personsPlaying);
//        }

        Person Dennis = new Person("Dennis");
        Person Oishi = new Person("Oishi");
        Person Rahul = new Person("Rahul");
        Person Sharu = new Person("Sharu");
        Person Omi = new Person("Omi");
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

        canGiftToPeronsListed(personsPlaying);
        System.out.println("Starting game: ");
        System.out.println("");

//        for (Person eachPerson : personsPlaying) {
//            System.out.println(eachPerson.getName() + " can give gift to ");
//            List<String> giftPersons = eachPerson.getCanGiftToList();
//            for(String person : giftPersons) {
//                System.out.println(person);
//            }
//            System.out.println("");
//        }


        playGame(personsPlaying);
        System.out.println("You have to buy gift for " + personsPlaying.get(1).getIsSecrectSantaOf());


//        for(Person eachPerson : personsPlaying) {
//            System.out.println("Person is " + eachPerson.getName() + " is secrest Santa for " + eachPerson.getIsSecrectSantaOf());
//        }

    }

    //Part of Secret Santa Part 3 section
    private static void setExclusions(List<Person> personsPlaying) {
        for (Person eachPerson : personsPlaying) {
            System.out.println("How many Exclusions for " + eachPerson.getName());
            Scanner exclusionPersonCountScanner = new Scanner(System.in);
            int exclusionPersonCount = exclusionPersonCountScanner.nextInt();
            for(int i = 0; i < exclusionPersonCount; i++) {
                System.out.println("Enter Exclusion " + (i+1) + " for " + eachPerson.getName());
                Scanner exclusionPersonScanner = new Scanner(System.in);
                String exclusionPerson = exclusionPersonScanner.nextLine();
                eachPerson.setExclusions(exclusionPerson);
            }
        }
    }

    private static void canGiftToPeronsListed(List<Person> personsPlaying) {
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
            int randomElementIndex = ThreadLocalRandom.current().nextInt(eachPerson.getCanGiftToList().size());
            List<String> canGiftTo = eachPerson.getCanGiftToList();
            secrectSanta = canGiftTo.get(randomElementIndex);
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
