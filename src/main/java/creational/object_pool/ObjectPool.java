package creational.object_pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

/**
 * Created on 11.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class ObjectPool <T extends Resetable> {
    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int count) {
        this.availablePool = new LinkedBlockingQueue<>(count);
        for (int i = 0; i < count; i++) {
            availablePool.offer(creator.get());
        }
    }

    public T get(){
        try {
            return availablePool.take();
        } catch (InterruptedException e) {
            log.error("Take was interrupted: {}", e.getMessage());
        }
        return null;
    }

    public void release(T object){
        object.reset();
        try {
            availablePool.put(object);
        } catch (InterruptedException e) {
            log.error("Put was interrupted: {}", e.getMessage());
        }
    }

    public int getPoolSize(){
        return availablePool.size();
    }
}
