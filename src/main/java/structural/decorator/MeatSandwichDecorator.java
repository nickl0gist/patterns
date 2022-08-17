package structural.decorator;

/**
 * Created on 17.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class MeatSandwichDecorator extends SandwichDecorator{
    public MeatSandwichDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String make() {
        return super.make() + " with turkey";
    }
}
