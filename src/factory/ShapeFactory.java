package factory;

public class ShapeFactory {

    public Shape getShape(String shape){
        if(shape == null){
            return null;
        }
        switch (shape.toUpperCase()){
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            case "TRIANGLE":
                return new Triangle();
            default:
                return null;
        }
    }
}
