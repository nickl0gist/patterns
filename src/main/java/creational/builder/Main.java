package creational.builder;

import creational.builder.builder.ProductBuilderA;
import creational.builder.builder.ProductBuilderB;
import creational.builder.product.Product;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 21.07.2022
 * <br>Study of Builder pattern. Main Class (Client)
 * @author Mykola Horkov
 * <br>mykola.horkov@gmail.com
 */
@Slf4j
public class Main {

    private static final String[] productA = {"3", "Product A", "2.05", "Some Parameter A", "215"};
    private static final String[] productB = {"12", "Product B", "22.50", "121200", "50.05"};

    public static void main(String[] args) {
        Product prodA = directBuildA(new ProductBuilderA(), productA);
        Product prodB = directBuildB(new ProductBuilderB(), productB);
        log.info("ProdA: {}", prodA);
        log.info("ProdB: {}", prodB);

    }

    //Director for Product A
    private static Product directBuildA(ProductBuilderA builder, String[] product){
        return builder.withId(Integer.parseInt(product[0]))
                .withName(product[1])
                .withPrice(Double.parseDouble(product[2]))
                .withStringParameterForProductA(product[3])
                .withIntParameterForProductA(Integer.parseInt(product[4]))
                .build();
    }

    //Director for Product B
    private static Product directBuildB(ProductBuilderB builder, String[] product){
        return builder.withId(Integer.parseInt(product[0]))
                .withName(product[1])
                .withPrice(Double.parseDouble(product[2]))
                .withLongParameterForProductB(Long.parseLong(product[3]))
                .withDoubleParameterForProductB(Double.parseDouble(product[4]))
                .build();
    }
}
