package Burger;

public class Hamburger {
    private String name;
    private String breadRollType;
    private String meat;
    private double price;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String breadRollType, String meat, double price) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addition1Item(String itemName, double price) {
        this.addition1Name = itemName;
        this.addition1Price = price;
    }

    public void addition2Item(String itemName, double price) {
        this.addition2Name = itemName;
        this.addition2Price = price;
    }

    public void addition3Item(String itemName, double price) {
        this.addition3Name = itemName;
        this.addition3Price = price;
    }

    public void addition4Item(String itemName, double price) {
        this.addition4Name = itemName;
        this.addition4Price = price;
    }

    public double itemizedBurger() {
        if(this.addition1Name != null) {
            System.out.println(this.addition1Name + " add for an extra $" + this.addition1Price);
            this.price += this.addition1Price;
        }

        if(this.addition2Name != null) {
            System.out.println(this.addition2Name + " add for an extra $" + this.addition2Price);
            this.price += this.addition2Price;
        }

        if(this.addition3Name != null) {
            System.out.println(this.addition3Name + " add for an extra $" + this.addition3Price);
            this.price += this.addition3Price;
        }

        if(this.addition4Name != null) {
            System.out.println(this.addition4Name + " add for an extra $" + this.addition4Price);
            this.price += this.addition4Price;
        }

        return this.price;
    }
}
