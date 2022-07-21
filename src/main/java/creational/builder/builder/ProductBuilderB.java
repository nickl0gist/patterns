package creational.builder.builder;

import creational.builder.product.ConcreteProductA;
import creational.builder.product.ConcreteProductB;
import creational.builder.product.Product;

/**
 * Created on 21.07.2022
 * @author Mykola Horkov
 * mykola.horkov@gmail.com
 */
public class ProductBuilderB implements ProductBuilder {

    private int id;
    private String name;
    private double price;
    private long longParameterForProductB;
    private double doubleParameterForProductB;
    private ConcreteProductB prodB;

    @Override
    public ProductBuilderB withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public ProductBuilderB withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilderB withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilderB withLongParameterForProductB(long longParameterForProductB){
        this.longParameterForProductB = longParameterForProductB;
        return this;
    }

    public ProductBuilderB withDoubleParameterForProductB(double doubleParameterForProductB){
        this.doubleParameterForProductB = doubleParameterForProductB;
        return this;
    }

    @Override
    public Product build() {
        prodB = new ConcreteProductB(this.id, this.name, this.price, this.longParameterForProductB, this.doubleParameterForProductB);
        return prodB;
    }

    @Override
    public Product getProduct() {
        return prodB;
    }
}
