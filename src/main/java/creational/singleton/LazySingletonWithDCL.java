package creational.singleton;

/**
 * Created on 09.08.2022
 * This class demonstrates singleton pattern using Double Checked Locking or "classic" Lazy Singleton.
 * This implementation solves the multi-threading issue with lazy initialization using volatile and double check locking,
 * the volatile keyword is guaranteed to work only after JVMs starting with version 1.5 and later.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class LazySingletonWithDCL {
    private LazySingletonWithDCL(){}

    private static volatile LazySingletonWithDCL INSTANCE;

    public static LazySingletonWithDCL getInstance(){
        if(INSTANCE == null){
            synchronized (LazySingletonWithDCL.class){
                if(INSTANCE == null){
                    INSTANCE = new LazySingletonWithDCL();
                }
            }
        }
        return INSTANCE;
    }
}
