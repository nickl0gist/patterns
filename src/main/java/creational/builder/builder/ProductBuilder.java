package creational.builder.builder;

import creational.builder.product.Product;

/**
 * Created on 21.07.2022
 * @author Mykola Horkov
 * mykola.horkov@gmail.com
 */
public interface ProductBuilder {
    ProductBuilder withId(int id);
    ProductBuilder withName(String name);
    ProductBuilder withPrice(double price);
    Product build();
    // (optional) to fetch already built Product after build() method in case build() is void.
    Product getProduct();
}
