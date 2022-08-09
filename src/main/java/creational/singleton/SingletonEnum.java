package creational.singleton;

/**
 * Created on 09.08.2022
 * (Ref. Google I/O 2k8 Joshua Bloch)
 * Since Java 1.5 using enum we can create a singleton. It handles serialization using java's built-in mechanism
 * and still single instance
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public enum SingletonEnum {
    INSTANCE;

    public void someMethod(){

    }
}
