package behavioral.template_method;

import lombok.Getter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 08.09.2022
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
    private double total;

    public Order(String id) {
        this.id = id;
        date = LocalDate.now();
    }

    public void addItem(String name, double price) {
        items.put(name, price);
        total+= price;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
