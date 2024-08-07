package factory.car_example;

public class CarFactory {

    private CarFactory(){

    }

    public static Nexon getInstance(String type){
        if(type == null){
            return null;
        }
        switch (type.toUpperCase()){
            case "EV":
                return new Ev();
            case "PETROL":
                return new Petrol();
            default:
                return null;
        }
    }
}
