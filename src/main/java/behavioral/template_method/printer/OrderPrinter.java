package behavioral.template_method.printer;

import behavioral.template_method.Order;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created on 08.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Abstract class which holds Template method <code>printOrder(...)</code>
 */
public abstract class OrderPrinter {

    public final void printOrder(Order order, String filename) throws IOException {
        try(PrintWriter writer = new PrintWriter(filename)){

            writer.println(start());

            writer.println(printSeparator());

            writer.println(formatOrderNumber(order));

            writer.println(formatItems(order));

            writer.println(formatTotal(order));

            writer.println(end());
        }
    }

    protected abstract String start();

    protected abstract String printSeparator();

    protected abstract String formatOrderNumber(Order order);

    protected abstract String formatItems(Order order);

    protected abstract String formatTotal(Order order);

    protected abstract String end();
}
