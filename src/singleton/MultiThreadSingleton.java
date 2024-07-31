package singleton;

public class MultiThreadSingleton {
    private static MultiThreadSingleton instance = null;
    private MultiThreadSingleton(){

    }
    public static MultiThreadSingleton getInstance(){
        if(instance == null){
            synchronized (MultiThreadSingleton.class){
                instance = new MultiThreadSingleton();
            }


        }
        return instance;
    }
}
