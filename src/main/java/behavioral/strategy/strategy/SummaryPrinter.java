package behavioral.strategy.strategy;

import behavioral.strategy.order.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created on 07.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Strategy implementation.
 */
@Slf4j
public class SummaryPrinter implements OrderPrinter {

    @Override
    public void print(Collection<Order> orders) {
        StringBuilder sB = new StringBuilder("\n*************** Summary Report ***************\n");
        Iterator<Order> iterator = orders.iterator();
        double total = 0;
        for (int i = 1; iterator.hasNext(); i++) {
            Order order = iterator.next();
            sB.append("*\t")
                    .append(i)
                    .append(". ")
                    .append(order.getId())
                    .append("\t")
                    .append(order.getDate())
                    .append("\t")
                    .append(order.getItems().size())
                    .append("\t")
                    .append(order.getTotal())
                    .append("\t\t\t *\n");
            total += order.getTotal();
        }
        sB.append("**********************************************\n");
        sB.append("\t\t\t\t\t  Total ").append(total);
        log.info(sB.toString());
    }
}
