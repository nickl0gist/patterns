package behavioral.strategy.strategy;

import behavioral.strategy.order.Order;

import java.util.Collection;

/**
 * Created on 07.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Strategy Interface
 */
public interface OrderPrinter {
    void print(Collection<Order> orders);
}
