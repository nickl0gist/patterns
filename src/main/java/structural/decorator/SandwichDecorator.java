package structural.decorator;

/**
 * Created on 17.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class SandwichDecorator implements Sandwich{

    private Sandwich sandwich;

    public SandwichDecorator(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String make() {
        return sandwich.make();
    }
}
