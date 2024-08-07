package factory.car_example;

public class Ev implements Nexon{
    @Override
    public void start() {
        System.out.println("Starting motor!");
    }

    @Override
    public void energy() {
        System.out.println("Battery enery source activated!");
    }
}
