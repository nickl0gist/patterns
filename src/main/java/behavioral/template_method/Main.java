package behavioral.template_method;

import behavioral.template_method.printer.HTMLPrinter;
import behavioral.template_method.printer.OrderPrinter;
import behavioral.template_method.printer.TextPrinter;

import java.io.IOException;

/**
 * Created on 08.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Template Design Pattern.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Order order = new Order("1001");

        order.addItem("Sparkling Water", 2.50);
        order.addItem("Watermelon", 11.95);
        order.addItem("Salmon", 15.95);

        OrderPrinter textPrinter = new TextPrinter();
        textPrinter.printOrder(order, "1001.txt");

        OrderPrinter htmlPrinter = new HTMLPrinter();
        htmlPrinter.printOrder(order, "1001.html");
    }
}
