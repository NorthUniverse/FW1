import java.util.Scanner;

public class Main {

    private static Scanner menuOptionscanner = new Scanner(System.in);

    public static void main(String[] args) {

        GroceryList groceryList = new GroceryList();
        boolean quit = false;

        printMenuOptions();

        while(!quit) {

            int menuOption = menuOptionscanner.nextInt();
            Scanner itemscanner = new Scanner(System.in);
            String item;
            switch (menuOption) {
                case 1 :
                    System.out.println("Enter an item to add on the grocery list ");
                    item = itemscanner.nextLine();
                    groceryList.addGroceryItem(item);
                    printMenuOptions();
                    break;
                case 2 :
                    System.out.println("Enter an item to remove on the grocery list ");
                    item = itemscanner.nextLine();
                    groceryList.removeGroceryItem(item);
                    printMenuOptions();
                    break;
                case 3 :
                    System.out.println("Enter the old item to be replaced ");
                    String oldItem = itemscanner.nextLine();
                    System.out.println("Now enter the new item ");
                    String newItem = itemscanner.nextLine();
                    groceryList.replaceGroceryItem(oldItem, newItem);
                    printMenuOptions();
                    break;
                case 4 :
                    String findItem = itemscanner.nextLine();
                    groceryList.findThisItem(findItem);
                    printMenuOptions();
                    break;
                case 5 :
                    System.out.println("The Grocery List is:  ");
                    groceryList.printGroceryList();
                    printMenuOptions();
                    break;
                case 6:
                    printMenuOptions();
                    break;
                case 7:
                    System.out.println("Exiting program ");
                    quit = true;
                    break;
            }
        }
    }

    private static void printMenuOptions() {
        System.out.println("1. Add item to the grocery list ");
        System.out.println("2. Remove item from the grocery list ");
        System.out.println("3. Replace item in the grocery list ");
        System.out.println("4. Find item in grocery list  ");
        System.out.println("5. Print the grocery list ");
        System.out.println("6. Print Menu Options ");
        System.out.println("7. Exit ");
    }
}
