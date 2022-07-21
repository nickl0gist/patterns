package creational.builder.product;

import lombok.*;

/**
 * Created on 21.07.2022
 * @author Mykola Horkov
 * mykola.horkov@gmail.com
 */
@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Product {
    private int id;
    private String name;
    private double price;
}
