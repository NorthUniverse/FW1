import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
        System.out.println(item + " was added to the grocery list");
    }

    public void printGroceryList() {
        for(int i=0 ; i < groceryList.size() ; i++) {
            System.out.println( (i+1) + ". " + groceryList.get(i));
        }
        System.out.println(" ");
    }

    public void removeGroceryItem(String item) {
        int i = groceryList.indexOf(item);
        groceryList.remove(i);
        System.out.println(item + " was removed from the grocery list");
    }

    public void replaceGroceryItem(String oldItem, String newItem) {
        int i = groceryList.indexOf(oldItem);
        groceryList.set(i, newItem);
        System.out.println(oldItem + " was removed and " + newItem + " was added to the list");
    }

    public void findThisItem(String findItem) {
        if(groceryList.contains(findItem)) {
            System.out.println(findItem + " is present in the grocery list ");
        }
        else {
            System.out.println(findItem + " is not present in the grocery list ");
        }
    }

}
