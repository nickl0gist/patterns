package structural.flyweight;

import com.madhukaraphatak.sizeof.SizeEstimator;
import javafx.geometry.Point2D;
import lombok.extern.slf4j.Slf4j;
import structural.flyweight.game.GameUnitRegular;
import structural.flyweight.game.flyweight_game.GameUnitFlyweight;
import structural.flyweight.game.flyweight_game.GameUnitFlyweightFactory;
import structural.flyweight.game.flyweight_game.UnsharedGameUnitFlyweight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Flyweight Design Pattern
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        List<GameUnitRegular> gameUnitRegularList = gameUnitRegularsGenerator();
        log.info("Regular Game units size {}", (SizeEstimator.estimate(gameUnitRegularList)/8/1024)+" mb");

        List<GameUnitFlyweight> gameUnitFlyweightList = gameUnitFlyweightGenerator();
        log.info("Flyweight Game units size {}", (SizeEstimator.estimate(gameUnitFlyweightList)/8/1024)+" mb");
    }

    private static List<GameUnitRegular> gameUnitRegularsGenerator(){
        List<GameUnitRegular> result = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            GameUnitRegular item = new GameUnitRegular();
            item.setLocation(new Point2D(i, i + 10.0));
            if (i % 2 == 0){
                item.setColor(Color.YELLOW);
            } else {
                item.setColor(Color.BLUE);
            }
            item.setName("Item"+i);
            item.setSpeed(i * 2);
            for (int j = 0; j < 100_000; j++) {
                item.getCharSet().add('a');
            }
            result.add(item);
        }
        return result;
    }

    private static List<GameUnitFlyweight> gameUnitFlyweightGenerator(){
        List<GameUnitFlyweight> result = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            result.add(new UnsharedGameUnitFlyweight(new Point2D(i, i + 10.0),"Item"+i,  i * 2));
        }
        result.add(GameUnitFlyweightFactory.getInstance().getCommonGameUnit(Color.YELLOW));
        result.add(GameUnitFlyweightFactory.getInstance().getCommonGameUnit(Color.BLACK));
        return result;
    }
}
