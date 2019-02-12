package Burger_Encapsulation_Polymorphism;

public class Main {

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Basic", "White", "Beef Patty",3.0);
        System.out.println("This is a " + hamburger.getName() + " burger with " + hamburger.getBreadRollType() + " bread roll type and " + hamburger.getMeat() + " priced at $" + hamburger.getPrice());
        hamburger.addition1Item("Lettuce", 0.3);
        hamburger.addition2Item("Tomato", 0.5);
        hamburger.addition3Item("Cheese", 1.1);
        System.out.println("Total price is " + hamburger.itemizedBurger());


        HealthyBurger healthyBurger = new HealthyBurger("Turkey", 5.0);
        System.out.println("This is a " + healthyBurger.getName() + " burger with " + healthyBurger.getBreadRollType() + " bread roll type and " + healthyBurger.getMeat() + " priced at $" + healthyBurger.getPrice());
        healthyBurger.healthyAddition1Item("Carrot", 0.4);
        healthyBurger.healthyAddition2Item("Onions", 0.6);
        System.out.println("Total price is " + healthyBurger.itemizedBurger());

        DeluxBurger deluxBurger = new DeluxBurger(6.0);
        System.out.println("This is a " + deluxBurger.getName() + " burger with " + deluxBurger.getBreadRollType() + " bread roll type and " + deluxBurger.getMeat() + " priced at $" + deluxBurger.getPrice());
        deluxBurger.addition1Item("Extra Meat", 0.4);
        System.out.println("Total price is " + deluxBurger.itemizedBurger());


    }

}
