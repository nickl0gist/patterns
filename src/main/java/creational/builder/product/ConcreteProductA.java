package creational.builder.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created on 21.07.2022
 * @author Mykola Horkov
 * mykola.horkov@gmail.com
 */
@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PUBLIC)
@ToString(callSuper = true)
public class ConcreteProductA extends Product{
    private String stringParameterForProductA;
    private int intParameterForProductA;

    public ConcreteProductA(int id, String name, double price, String stringParameterForProductA, int intParameterForProductA) {
        super(id, name, price);
        this.stringParameterForProductA = stringParameterForProductA;
        this.intParameterForProductA = intParameterForProductA;
    }
}
