package behavioral.template_method.printer;

import behavioral.template_method.Order;

/**
 * Created on 08.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete implementation. Implements steps needed by template method.
 */
public class HTMLPrinter extends OrderPrinter {
    @Override
    protected String start() {
        return "<html><head><title>-= Order Details =-</title></head><body>";
    }

    @Override
    protected String printSeparator() {
        return "<hr>";
    }

    @Override
    protected String formatOrderNumber(Order order) {
        return "<h1>Order #" + order.getId() + "</h1>";
    }

    @Override
    protected String formatItems(Order order) {

        StringBuilder builder = new StringBuilder(printSeparator() + "<h3>Items:</h3><p><ul>");

        order.getItems().forEach((key, value) ->
                builder.append("<li>")
                        .append(key)
                        .append(" $")
                        .append(value)
                        .append("</li>"));

        builder.append("</ul></p>").append(printSeparator());
        return builder.toString();
    }

    @Override
    protected String formatTotal(Order order) {
        return "<h3>Total : $"+order.getTotal()+"</h3>";
    }

    @Override
    protected String end() {
        return printSeparator()+"</body></html>";
    }
}
