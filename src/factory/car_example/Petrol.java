package factory.car_example;

public class Petrol implements Nexon{

    @Override
    public void start() {
        System.out.println("Starting Engine!");
    }

    @Override
    public void energy() {
        System.out.println("Energy from Petrol");
    }
}
