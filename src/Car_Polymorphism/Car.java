package Car_Polymorphism;

public class Car {
    private String name;
    private boolean engine;
    int cylinders;
    int wheels;
    int doors;

    public Car(String name, int cylinders, int doors) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.doors = doors;
    }

    public void startEngine() {
        System.out.println("Starting engine... Vroom....");
    }

    public void accelerate() {
        System.out.println("Accelerating " + this.name + " car ");
    }

    public void brake() {
        System.out.println("Braking " + this.name + " car ");
    }
}
