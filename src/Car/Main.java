package Car;

public class Main {

    public static void main(String[] args) {
        BMW carrera = new BMW("Carrera", 4, 2);
        F1 mcLarren = new F1("McLarren", 16, 0);

        carrera.startEngine();
        carrera.accelerate();
        carrera.brake();

        mcLarren.startEngine();
        mcLarren.accelerate();
        mcLarren.brake();
    }

}

