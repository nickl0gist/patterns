package creational.singleton;

/**
 * Created on 09.08.2022
 * Singleton Pattern using lazy initialization holder class. This ensures that,
 * we have a lazy initialization without worrying about synchronization.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class LazySingletonIHI {
    public LazySingletonIHI() {}

    private static class SingletonHolder{
        static LazySingletonIHI INSTANCE = new LazySingletonIHI();
    }

    public static LazySingletonIHI getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
