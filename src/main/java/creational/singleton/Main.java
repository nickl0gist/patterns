package creational.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 09.08.2022
 * Study of Singleton Design Pattern
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        //Eager Singleton
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        log.info("eagerSingleton1 and eagerSingleton2 reference to same instance: {}", eagerSingleton1 == eagerSingleton2);

        //Double Checked Locking Lazy Singleton
        LazySingletonWithDCL lazySingletonWithDCL1 = LazySingletonWithDCL.getInstance();
        LazySingletonWithDCL lazySingletonWithDCL2 = LazySingletonWithDCL.getInstance();
        log.info("lazySingletonWithDCL1 and lazySingletonWithDCL2 reference to same instance: {}", lazySingletonWithDCL1 == lazySingletonWithDCL2);

        //Lazy initialization holder class
        LazySingletonIHI lazySingletonIHI1 = LazySingletonIHI.getInstance();
        LazySingletonIHI lazySingletonIHI2 = LazySingletonIHI.getInstance();
        log.info("lazySingletonIHI1 and lazySingletonIHI2 reference to same instance: {}", lazySingletonIHI1 == lazySingletonIHI2);

        //Singleton Enum by Joshua Bloch
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        log.info("singletonEnum1 and singletonEnum2 reference to same instance: {}", singletonEnum1 == singletonEnum2);
    }
}
