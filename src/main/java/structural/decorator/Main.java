package structural.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 17.08.2022
 * <br>Study of Decorator (Wrapper) design pattern.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Sandwich sandwich = new SimpleSandwich();
        Sandwich meatDecorator = new MeatSandwichDecorator(sandwich);
        Sandwich mustardDecorator = new MustardSandwichDecorator(meatDecorator);

        log.info(mustardDecorator.make());
    }
}
