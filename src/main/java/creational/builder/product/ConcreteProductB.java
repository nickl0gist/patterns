package creational.builder.product;

import lombok.*;

/**
 * Created on 21.07.2022
 * @author Mykola Horkov
 * mykola.horkov@gmail.com
 */
@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PUBLIC)
@ToString(callSuper = true)
public class ConcreteProductB extends Product {
    private long longParameterForProductB;
    private double doubleParameterForProductB;

    public ConcreteProductB(int id, String name, double price, long longParameterForProductB, double doubleParameterForProductB) {
        super(id, name, price);
        this.longParameterForProductB = longParameterForProductB;
        this.doubleParameterForProductB = doubleParameterForProductB;
    }
}
