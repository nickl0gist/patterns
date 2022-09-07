package behavioral.strategy;

import behavioral.strategy.order.Order;
import behavioral.strategy.strategy.DetailPrinter;
import behavioral.strategy.strategy.SummaryPrinter;

import java.util.LinkedList;

/**
 * Created on 07.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study Strategy design pattern.
 */
public class Main {

    private static final LinkedList<Order> orders = new LinkedList<>();

    public static void main(String[] args) {
        createOrders();
        //print all orders with DetailPrinter implementation of OrderPrinter
        PrintService service = new PrintService(new DetailPrinter());
        service.printOrders(orders);
        System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-=-=-\n\n");
        //print all orders with SummaryPrinter implementation of OrderPrinter
        service.setOrderPrinter(new SummaryPrinter());
        service.printOrders(orders);

    }

    private static void createOrders() {
        Order o = new Order("101");
        o.addItem("Water", 5);
        o.addItem("Mushrooms", 10);
        orders.add(o);

        o = new Order("201");
        o.addItem("Watermelon", 20);
        o.addItem("Grape", 15);
        o.addItem("Lemon", 9);
        orders.add(o);

        o = new Order("301");
        o.addItem("Celery", 8);
        o.addItem("Cabbage", 5);
        orders.add(o);
    }
}
