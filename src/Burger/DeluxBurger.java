package Burger;

public class DeluxBurger extends Hamburger{
    public DeluxBurger(double price) {
        super("Delux", "White", "Double Patty", price);
        super.addition1Item("Fries", 1.0);
        super.addition2Item("Drink", 2.0);
    }

    @Override
    public void addition1Item(String itemName, double price) {
        System.out.println("Cant do this");
    }

    @Override
    public void addition2Item(String itemName, double price) {
        System.out.println("Cant do this");
    }

    @Override
    public void addition3Item(String itemName, double price) {
        System.out.println("Cant do this");
    }

    @Override
    public void addition4Item(String itemName, double price) {
        System.out.println("Cant do this");
    }
}
