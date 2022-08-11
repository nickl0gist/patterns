package creational.object_pool;

import javafx.geometry.Point2D;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 11.08.2022
 * Study of Object Poll Design Pattern
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {
    public static final ObjectPool<Bitmap> bitmapPool = new ObjectPool<>(() -> new Bitmap("SomeImg.bmp"), 2);

    public static void main(String[] args) {
        Bitmap img1 = bitmapPool.get();
        img1.setLocation(new Point2D(5, 17));

        Bitmap img2 = bitmapPool.get();
        img2.setLocation(new Point2D(-10, 27));

        img1.draw();
        img2.draw();

        log.info("Actual Pool Size is {}", bitmapPool.getPoolSize());

        bitmapPool.release(img1);
        bitmapPool.release(img2);

        log.info("Pool Size after releasing objects is {}", bitmapPool.getPoolSize());
    }
}
