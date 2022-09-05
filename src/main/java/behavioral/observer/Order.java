package behavioral.observer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 05.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete Subject (publisher, observable).
 */
public class Order {

    private final String id;

    @Setter
    private double shippingCosts;

    // Costs of items in the Order.
    @Getter
    private double itemCost;

    @Setter
    private double discount;

    //qty of items in the Order.
    @Getter
    private int itemQty;

    // Collection of Observers subscribed to Order.
    private final List<OrderObserver> observers = new ArrayList<>();

    public Order(String id) {
        this.id = id;
    }

    /**
     * Add Order subscriber to List.
     */
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    /**
     * Remove Order subscriber to List.
     */
    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public double getTotalCost() {
        return itemCost - discount + shippingCosts;
    }

    public void addItem(double price) {
        itemCost += price;
        itemQty++;
        observers.forEach(o -> o.updated(this));
    }

    @Override
    public String toString() {

        return "Order #" + id + ":\nItem cost:" + itemCost + "\nNo. of items:" + itemQty
                + "\nShipping cost:" + shippingCosts + "\nDiscount:" + discount
                + "\nTotal:" + getTotalCost();
    }
}
