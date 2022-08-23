package structural.flyweight.game.flyweight_game;

import javafx.geometry.Point2D;

/**
 * Created on 23.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Interface implemented by Flyweights.
 */
public interface GameUnitFlyweight {
    String getUnitDescription(Point2D location, String name, int speed);
}
