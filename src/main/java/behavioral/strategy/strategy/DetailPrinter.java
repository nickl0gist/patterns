package behavioral.strategy.strategy;

import behavioral.strategy.order.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created on 07.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Strategy implementaition.
 */
@Slf4j
public class DetailPrinter implements OrderPrinter {

    private static final String LINE_SEPARATOR = "----------------------------------------\n";

    @Override
    public void print(Collection<Order> orders) {
        StringBuilder sB = new StringBuilder("\n************* Detail Report *************\n");
        Iterator<Order> iter = orders.iterator();
        double total = 0;
        for (int i = 1; iter.hasNext(); i++) {
            double orderTotal = 0;
            Order order = iter.next();
            sB.append(i)
                    .append(". ")
                    .append(order.getId())
                    .append(" \t")
                    .append(order.getDate())
                    .append("\n");
            for (Map.Entry<String, Double> entry : order.getItems().entrySet()) {
                sB.append("\t\t")
                        .append(entry.getKey())
                        .append("\t")
                        .append(entry.getValue())
                        .append("\n");
                orderTotal += entry.getValue();
            }
            sB.append(LINE_SEPARATOR);
            sB.append("\t\t Total  ")
                    .append(orderTotal)
                    .append("\n");
            sB.append(LINE_SEPARATOR);
            total += orderTotal;
        }
        sB.append(LINE_SEPARATOR);
        sB.append("\tGrand Total: ").append(total).append("\n\n");
        log.info(sB.toString());
    }
}
