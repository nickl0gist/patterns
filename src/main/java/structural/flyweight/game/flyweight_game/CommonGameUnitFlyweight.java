package structural.flyweight.game.flyweight_game;

import javafx.geometry.Point2D;

import java.awt.*;
import java.util.List;

/**
 * Created on 23.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> A Concrete Flyweight. Instance is shared.
 */
public class CommonGameUnitFlyweight implements GameUnitFlyweight {

    private final List<Character> charSet;
    private final Color color;

    public CommonGameUnitFlyweight(Color color, List<Character> charSet) {
        this.charSet = charSet;
        this.color = color;
    }

    @Override
    public String getUnitDescription(Point2D location, String name, int speed) {
        return "Game Unit " + name + " |" +
                " location: " + location + " |" +
                " speed: " + speed + " |" +
                " charSet size: " + charSet.size() + " |" +
                " color: " + color + ".";
    }
}
