package creational.object_pool;


import javafx.geometry.Point2D;

/**
 * Created on 11.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface Image extends Resetable{
    void draw();

    Point2D getLocation();

    void setLocation(Point2D location);
}
