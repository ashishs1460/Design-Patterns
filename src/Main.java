import singleton.EnumSingleton;
import singleton.LazySingleton;
import singleton.SerializableSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        LazySingleton obj1 = LazySingleton.getInstance();
        LazySingleton obj2 = LazySingleton.getInstance();
//        System.out.println(obj1.hashCode() == obj2.hashCode());

//        BreakingReflection();
        BreakingSynchronization();

    }

    private static void BreakingSynchronization() throws IOException, ClassNotFoundException {
        // When a singleton class is serialized and then deserialized , a new instance can be created !
        LazySingleton lazySingleton = LazySingleton.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(lazySingleton);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        LazySingleton deserializedLazy = (LazySingleton) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Object 1 :" + lazySingleton.hashCode());
        System.out.println("Object 2 :" + deserializedLazy.hashCode());

        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream("object1.obj"));
        objectOutputStream2.writeObject(serializableSingleton);
        objectOutputStream2.close();
        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream("object1.obj"));
        SerializableSingleton deserializedInstance = (SerializableSingleton) objectInputStream2.readObject();
        objectInputStream2.close();
        System.out.println("SerializableSingleton Object 1 :" + serializableSingleton.hashCode());
        System.out.println(" SerializableSingleton Object 2 :" + deserializedInstance.hashCode());
    }

    private static void BreakingReflection() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = null;
        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);
        lazySingleton1 = (LazySingleton) constructor.newInstance();
        System.out.println(lazySingleton.hashCode() == lazySingleton1.hashCode());
        // we can resolve this via creating a singleton class of type enum
        EnumSingleton obj1 = EnumSingleton.INSTANCE;
        EnumSingleton obj2 = EnumSingleton.INSTANCE;
        System.out.println("Enum Singleton : "+ obj1 + " "+obj2);
    }
}