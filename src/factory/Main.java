package factory;

public class Main {
    /*Factory Design pattern is a design pattern in Object Oriented Programming
    * to create object of a class without specifying the exact class to be instantiated.
    * In this approach a single function or a class called factory handles the creation of object*/
    public static void main(String[] args) {



        Shape obj = ShapeFactory.getShape("square");
        if(obj!=null){
            obj.draw();
        }

    }

}
