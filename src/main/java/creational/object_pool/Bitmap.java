package creational.object_pool;

import javafx.geometry.Point2D;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 11.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Bitmap implements Image{

    private Point2D location;
    private String name;

    public Bitmap(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        log.info("Drawing {} at {}", name, location);
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void setLocation(Point2D location) {
        this.location = location;
    }

    @Override
    public void reset() {
        location =null;
        log.info("Bitmap location has been reset.");
    }
}
