package Jukebox_LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        LinkedList<String> cityList = new LinkedList<String>();

//        cityList.add("City C");
//        cityList.add("City F");
//        cityList.add("City A");
//        cityList.add("City B");
//        cityList.add("City D");
//        cityList.add("City G");
//        cityList.add("City H");
//
//        printCities(cityList);
//
//        cityList.add(4,"City E");
//        printCities(cityList);
//
//        cityList.remove(6);
//        printCities(cityList);

        addCitiesSorted(cityList, "City C");
        addCitiesSorted(cityList, "City F");
        addCitiesSorted(cityList, "City A");
        addCitiesSorted(cityList, "City B");
        addCitiesSorted(cityList, "City D");
        addCitiesSorted(cityList, "City G");
        addCitiesSorted(cityList, "City H");

        printCities(cityList);

        addCitiesSorted(cityList, "City E");
        printCities(cityList);
        visit(cityList);

    }

    private static void printCities(LinkedList<String> cityLists) {
        ListIterator<String> i = cityLists.listIterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(" ");

    }

    public static boolean addCitiesSorted(LinkedList<String> cityList, String newCity) {
        ListIterator<String> i = cityList.listIterator();

        while (i.hasNext()) {
            int comaprison = i.next().compareTo(newCity);

            if (comaprison == 0) {
                System.out.println(newCity + " already exists in the list! Not adding " + newCity + " to our Linked list");
            } else if (comaprison > 0) {
                i.previous();
                i.add(newCity);
                return true;
            } else if (comaprison < 0) {
                //Moving to next record;
            }
        }
        cityList.add(newCity);
        return true;
    }

    public static void visit(LinkedList<String> cityList) {
        if (cityList.isEmpty()) {
            System.out.println(" City list is empty");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingforward = true;
        printMenu();

        ListIterator<String> i = cityList.listIterator();

        while (!quit) {

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Exiting!");
                    quit = true;
                    break;
                case 1:
                    if (!goingforward) {
                        i.next();
                        goingforward = true;
                    }
                    if (i.hasNext()) {
                        System.out.println("Now visiting -> " + i.next());
                    } else {
                        System.out.println("You have reached the end of the list");
                    }
                    break;
                case 2:
                    if (goingforward) {
                        i.previous();
                        goingforward = false;
                    }
                    if (i.hasPrevious()) {
                        System.out.println("Now visiting -> " + i.previous());
                    } else {
                        System.out.println("You have reached the start of the list");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid option, now exiting!");
                    quit = true;
                    break;

            }
        }
    }

    public static void printMenu() {
        System.out.println("0 -> Exit");
        System.out.println("1 -> Next");
        System.out.println("2 -> Previous");
        System.out.println("3 -> Print Menu");
    }

}

