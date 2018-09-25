package Jukebox;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

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

        System.out.println("City List:");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(" ");

    }

    private static boolean addCitiesSorted(LinkedList<String> cityLists, String newCity) {
        ListIterator<String> i = cityLists.listIterator();

        while (i.hasNext()) {
            int comparison = i.next().compareTo(newCity);

            if (comparison == 0) {
                System.out.println(newCity + " already exists, hence " + newCity + " is not added to list!");
                return false;
            } else if (comparison > 0) {
                i.previous();
                i.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move to next element;
            }

        }

        i.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cityLists) {
        Scanner scanner  = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> i = cityLists.listIterator();

        if (cityLists.isEmpty()) {
            System.out.println("List is empty!");
        }
        else {
            System.out.println("Now visiting ->" + i.next());
        }

        while(!quit) {

            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Vacay over");
                    quit = true;
                    break;
                case 1:
                    if(i.hasNext()) {
                        System.out.println("Now visiting ->" + i.next());
                    }
                    else {
                        System.out.println("You reach the end of the list!");
                    }
                    break;
                case 2:
                    if(i.hasPrevious()) {
                        System.out.println("Now visiting ->" + i.previous());
                    }
                    else {
                        System.out.println("You reach the start of the list!");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                default :
                    quit = true;
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("0 - Exit");
        System.out.println("1 - Go to Next City");
        System.out.println("2 - Go to Previous City");
        System.out.println("3 - Print Menu");
    }
}
