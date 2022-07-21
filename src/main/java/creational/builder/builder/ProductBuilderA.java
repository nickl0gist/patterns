package creational.builder.builder;

import creational.builder.product.ConcreteProductA;
import creational.builder.product.Product;
import lombok.NoArgsConstructor;

/**
 * Created on 21.07.2022
 * @author Mykola Horkov
 * mykola.horkov@gmail.com
 */
@NoArgsConstructor
public class ProductBuilderA implements ProductBuilder{

    private int id;
    private String name;
    private double price;
    private String stringParameterForProductA;
    private int intParameterForProductA;
    private ConcreteProductA prodA;

    @Override
    public ProductBuilderA withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public ProductBuilderA withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilderA withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilderA withStringParameterForProductA(String stringParameterForProductA){
        this.stringParameterForProductA = stringParameterForProductA;
        return this;
    }

    public ProductBuilderA withIntParameterForProductA(int intParameterForProductA){
        this.intParameterForProductA = intParameterForProductA;
        return this;
    }

    @Override
    public Product build() {
        prodA = new ConcreteProductA(this.id, this.name, this.price, this.stringParameterForProductA, this.intParameterForProductA);
        return prodA;
    }

    @Override
    public Product getProduct() {
        return prodA;
    }
}
