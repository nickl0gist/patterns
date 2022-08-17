package structural.decorator;

/**
 * Created on 17.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class SimpleSandwich implements Sandwich {
    @Override
    public String make() {
        return "Bread";
    }
}
