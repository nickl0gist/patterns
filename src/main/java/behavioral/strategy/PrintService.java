package behavioral.strategy;

import behavioral.strategy.order.Order;
import behavioral.strategy.strategy.OrderPrinter;
import lombok.Setter;

import java.util.List;

/**
 * Created on 07.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Context holder.
 */
public class PrintService {

    @Setter
    private OrderPrinter orderPrinter;

    public PrintService(OrderPrinter orderPrinter) {
        this.orderPrinter = orderPrinter;
    }

    public void printOrders(List<Order> orders){
        orderPrinter.print(orders);
    }
}
