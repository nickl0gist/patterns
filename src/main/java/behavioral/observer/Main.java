package behavioral.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 05.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Observer design pattern.
 */
@Slf4j
public class Main {
    public static void main(String[] args) {

        Order order = new Order("101");

        PriceObserver priceObserver = new PriceObserver();
        order.attach(priceObserver);

        QuantityObserver quantityObserver = new QuantityObserver();
        order.attach(quantityObserver);

        order.addItem(50);
        order.addItem(179);
        order.addItem(35);
        order.addItem(84);
        order.addItem(153);
        order.addItem(10);

        log.info(order.toString());
    }
}
