package structural.flyweight.game;

import javafx.geometry.Point2D;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Setter
@Getter
public class GameUnitRegular {

    // Intrinsic values, common for multiple objects. To be extracted to SharedConcreteFlyweight class.
    private List<Character> charSet = new ArrayList<>(); // 54 byte for 100'000 item Char list.
    private Color color; // 4 byte. Only YELLOW and BLUE colors will be used.

    // Extrinsic values. Unique for each object. To be placed in UnsharedConcreteFlyweight class.
    private Point2D location; // 4 byte
    private String name; // 7 byte
    private int speed; // 3 byte
}
