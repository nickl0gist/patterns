package creational.singleton;

/**
 * Created on 09.08.2022
 * Eager initialization of Singleton instance.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class EagerSingleton {
    private EagerSingleton() { } // Hides constructor from outside. Disallows object creation outside.

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return INSTANCE;
    }
}
