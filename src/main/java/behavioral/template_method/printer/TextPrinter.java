package behavioral.template_method.printer;

import behavioral.template_method.Order;

/**
 * Created on 08.09.2022
 *
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Concrete implementation. Implements steps needed by template method.
 */
public class TextPrinter extends OrderPrinter {
    @Override
    protected String start() {
        return "\t-= Order Details =-";
    }

    @Override
    protected String printSeparator() {
        return "\n------------------------------\n";
    }

    @Override
    protected String formatOrderNumber(Order order) {
        return "Order #" + order.getId();
    }

    @Override
    protected String formatItems(Order order) {
        StringBuilder builder = new StringBuilder("Items: " + printSeparator() + "\n");
        order.getItems().forEach((key, value) ->
                builder.append(key)
                        .append(" $")
                        .append(value)
                        .append("\n"));
        builder.append(printSeparator());
        return builder.toString();
    }

    @Override
    protected String formatTotal(Order order) {
        return "Total: $" + order.getTotal();
    }

    @Override
    protected String end() {
        String tU = " THANK  YOU ";
        return printSeparator().substring(0, printSeparator().length()/2 - tU.length()/2)
                + tU
                + printSeparator().substring(printSeparator().length()/2 + tU.length()/2);
    }
}
