package creational.builder;

import creational.builder.builder.ProductBuilderA;
import creational.builder.builder.ProductBuilderB;
import creational.builder.product.Product;

/**
 * Created on 21.07.2022
 * Study of Builder pattern. Main CLass (Client)
 * @author Mykola Horkov
 * mykola.horkov@gmail.com
 */
public class Main {

    private static String[] productA = {"3", "Product A", "2.05", "Some Parameter A", "215"};
    private static String[] productB = {"12", "Product B", "22.50", "121200", "50.05"};

    public static void main(String[] args) {
        Product prodA = directBuildA(new ProductBuilderA(), productA);
        Product prodB = directBuildB(new ProductBuilderB(), productB);
        System.out.println("ProdA: " + prodA);
        System.out.println("ProdB: " + prodB);

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
