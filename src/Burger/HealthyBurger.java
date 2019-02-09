package Burger;

public class HealthyBurger extends Hamburger {

    public HealthyBurger(String meat, double price) {
        super("Healthy Burger", "Wheat Rye", meat, price);
    }

    private String healthyItem1Name;
    private double healthyItem1Price;

    private String healthyItem2Name;
    private double healthyItem2Price;

    public void healthyAddition1Item(String itemName, double price) {
        this.healthyItem1Name = itemName;
        this.healthyItem1Price = price;
    }

    public void healthyAddition2Item(String itemName, double price) {
        this.healthyItem2Name = itemName;
        this.healthyItem2Price = price;
    }

    @Override
    public double itemizedBurger() {
        super.itemizedBurger();

        if(this.healthyItem1Name != null) {
            System.out.println(this.healthyItem1Name + " add for an extra $" + this.healthyItem1Price);
            super.setPrice(super.getPrice() + this.healthyItem1Price);
        }

        if(this.healthyItem2Name != null) {
            System.out.println(this.healthyItem2Name + " add for an extra $" + this.healthyItem2Price);
            super.setPrice(super.getPrice() + this.healthyItem2Price);
        }
        return super.getPrice();
    }
}
