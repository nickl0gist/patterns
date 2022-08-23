package structural.flyweight.game.flyweight_game;

import javafx.geometry.Point2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 23.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> FLyweight factory. Returnsshared flyweight based on key
 */
public class GameUnitFlyweightFactory {

    private static final GameUnitFlyweightFactory FACTORY = new GameUnitFlyweightFactory();

    public static GameUnitFlyweightFactory getInstance(){
        return FACTORY;
    }

    private Map<Color, CommonGameUnitFlyweight> commonStateUnits = new HashMap<>();

    private GameUnitFlyweightFactory() {
        List<Character> listY = new ArrayList<>();
        List<Character> listB = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            listY.add('y');
            listB.add('b');
        }
        commonStateUnits.put(Color.YELLOW, new CommonGameUnitFlyweight(Color.YELLOW, listY));
        commonStateUnits.put(Color.BLACK, new CommonGameUnitFlyweight(Color.BLACK, listB));
    }

    public CommonGameUnitFlyweight getCommonGameUnit(Color color){
        return commonStateUnits.get(color);
    }

    public UnsharedGameUnitFlyweight getUnsharedGameUnit(Point2D location, String name, int speed){
        return new UnsharedGameUnitFlyweight(location,name, speed);
    }
}
