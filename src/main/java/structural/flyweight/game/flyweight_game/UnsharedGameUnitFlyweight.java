package structural.flyweight.game.flyweight_game;

import javafx.geometry.Point2D;

/**
 * Created on 23.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Unshared concrete Flyweight
 */
public class UnsharedGameUnitFlyweight implements GameUnitFlyweight{

    private Point2D location; // 4 byte
    private String name; // 7 byte
    private int speed; // 3 byte

    public UnsharedGameUnitFlyweight(Point2D location, String name, int speed) {
        this.location = location;
        this.name = name;
        this.speed = speed;
    }

    /**
     * Extrinsic state arguments are ignored.
     */
    @Override
    public String getUnitDescription(Point2D location, String name, int speed) {
        return "Game Unit " + this.name + " |" +
                " location: " + this.location + " |" +
                " speed: " + this.speed + " |";
    }
}
