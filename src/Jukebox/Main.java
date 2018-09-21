package Jukebox;

import java.util.LinkedList;
import java.util.ListIterator;

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
//        cityList.add("City E");
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

    }

    private static void printCities(LinkedList<String> cityLists) {
        ListIterator<String> i = cityLists.listIterator();

        System.out.println("City List:");
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println(" ");

    }

    private static void addCitiesSorted(LinkedList<String> cityLists, String newCity) {
        ListIterator<String> i = cityLists.listIterator();

        System.out.println("Sorted City List:");
        while(i.hasNext()) {
            int comparison = i.next().compareTo(newCity);

            
        }
        System.out.println(" ");
    }
}
