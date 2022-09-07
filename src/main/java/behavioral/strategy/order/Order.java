package behavioral.strategy.order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 07.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class Order {
    @Getter
    private final String id;

    @Getter
    private final LocalDate date;

    @Getter
    private final Map<String, Double> items = new HashMap<>();

    @Getter
    @Setter
    private double total;

    public Order(String id) {
        this.id = id;
        date = LocalDate.now();
    }

    public void addItem(String name, double price) {
        items.put(name, price);
        total+= price;
    }
}
