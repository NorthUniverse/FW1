package Car_Polymorphism;

public class BMW extends Car{
    public BMW(String name, int cylinders, int doors) {
        super(name, cylinders, doors);
    }

    public void startEngine() {
        System.out.println("Starting BMW Car_Polymorphism...");
    }
}
