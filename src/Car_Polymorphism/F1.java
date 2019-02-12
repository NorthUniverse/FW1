package Car_Polymorphism;

public class F1 extends Car{
    public F1(String name, int cylinders, int doors) {
        super(name, cylinders, doors);
    }
    public void startEngine() {
        System.out.println("Starting F1 Car_Polymorphism...");
    }
}
